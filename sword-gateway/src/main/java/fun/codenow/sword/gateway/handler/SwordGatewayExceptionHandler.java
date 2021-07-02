package fun.codenow.sword.gateway.handler;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/7/2 15:28
 **/
@Slf4j
@Getter
@Setter
public class SwordGatewayExceptionHandler implements ErrorWebExceptionHandler {

    private List<HttpMessageReader<?>> messageReaders = Collections.emptyList();
    private List<HttpMessageWriter<?>> messageWriters = Collections.emptyList();
    private List<ViewResolver> viewResolvers = Collections.emptyList();
    private ThreadLocal<Map> threadLocal=new ThreadLocal<>();
    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        log.error("网关异常请求处理，异常信息：{}",throwable.getMessage());
        //这里只是做个最简单的同一的异常结果输出，实际业务可根据throwable不同的异常处理不同的逻辑
        Map resultMap=new HashMap();
        if (throwable instanceof NotFoundException ||(throwable.getMessage()!=null&&throwable.getMessage().contains("503"))) {
            resultMap.put("code", -1);
            resultMap.put("message","请求的服务资源异常");
            resultMap.put("data","请求的服务资源异常，请联系管理员");
        }else if (throwable instanceof NotFoundException ||(throwable.getMessage()!=null&&throwable.getMessage().contains("404"))) {
            resultMap.put("code", -1);
            resultMap.put("message","请求的资源路径不存在");
            resultMap.put("data","请求的资源路径不存在，请检查路径是否合法");
        }else if (throwable instanceof ResponseStatusException){
            ResponseStatusException responseStatusException = (ResponseStatusException) throwable;
            resultMap.put("code", -1);
            resultMap.put("message","请求处理异常");
            resultMap.put("data",responseStatusException.getMessage());
        }else {
            resultMap.put("code", -1);
            resultMap.put("message","请求处理异常");
            resultMap.put("data","服务处理失败，请稍后重试");
        }

        ServerRequest newRequest = ServerRequest.create(serverWebExchange, this.messageReaders);
        threadLocal.set(resultMap);
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse).route(newRequest)
                .switchIfEmpty(Mono.error(throwable))
                .flatMap((handler) -> handler.handle(newRequest))
                .flatMap((response) -> write(serverWebExchange, response));
    }
    /**
     * 统一返回指定异常信息(指定json格式输出)
     * @param request
     * @return
     */
    protected Mono<ServerResponse> renderErrorResponse(ServerRequest request){
        return ServerResponse.status( HttpStatus.valueOf(200))
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(threadLocal.get()));
    }

    /**
     * 参考DefaultErrorWebExceptionHandler
     */
    private Mono<? extends Void> write(ServerWebExchange exchange, ServerResponse response) {
        exchange.getResponse().getHeaders().setContentType(response.headers().getContentType());
        return response.writeTo(exchange, new ResponseContext());
    }


    /**
     * 参考DefaultErrorWebExceptionHandler
     */
    private class ResponseContext implements ServerResponse.Context {
        private ResponseContext() {
        }

        @Override
        public List<HttpMessageWriter<?>> messageWriters() {
            return SwordGatewayExceptionHandler.this.messageWriters;
        }

        @Override
        public List<ViewResolver> viewResolvers() {
            return SwordGatewayExceptionHandler.this.viewResolvers;
        }
    }

}
