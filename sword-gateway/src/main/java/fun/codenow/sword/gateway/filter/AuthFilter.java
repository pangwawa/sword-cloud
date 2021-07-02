package fun.codenow.sword.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import fun.codenow.sword.common.ResponseData;
import fun.codenow.sword.common.constant.AuthConstant;
import fun.codenow.sword.common.model.dto.ApiLogDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/7/2 11:39
 **/
@Slf4j
@Component
@AllArgsConstructor
public class AuthFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
       /* String originalRequestUrl = getOriginalRequestUrl(exchange);*/
        String path = exchange.getRequest().getURI().getPath();
        String token=null;
        String headerToken = exchange.getRequest().getHeaders().getFirst(AuthConstant.AUTH_KEY);
        String paramToken = exchange.getRequest().getQueryParams().getFirst(AuthConstant.AUTH_KEY);
        ServerHttpResponse resp = exchange.getResponse();
        if (StringUtils.isEmpty(headerToken)&&StringUtils.isEmpty(paramToken)){
            log.error("未携带令牌，非法请求");
            /*return unAuth(resp, "缺失令牌,鉴权失败");*/
        }
        token=headerToken;
        if (StringUtils.isEmpty(headerToken)){
            token=paramToken;
        }
        log.info("apiLog  { time:{},methodValue:{},path:{},token:{},queryParams:{},headers:{} }", LocalDateTime.now(),exchange.getRequest().getMethodValue(),path,token,exchange.getRequest().getQueryParams().toString(),exchange.getRequest().getHeaders());

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }

    private Mono<Void> unAuth(ServerHttpResponse resp, String msg) {
        resp.setStatusCode(HttpStatus.UNAUTHORIZED);
        resp.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        String result = "";
        result = new Gson().toJson(ResponseData.restResult(null,401,msg));
        DataBuffer buffer = resp.bufferFactory().wrap(result.getBytes(StandardCharsets.UTF_8));
        return resp.writeWith(Flux.just(buffer));
    }
}
