package fun.codenow.sword.gateway.filter;

import com.google.gson.Gson;
import fun.codenow.sword.common.constant.AuthConstant;
import fun.codenow.sword.common.model.dto.ApiLogDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;


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
        if (StringUtils.isEmpty(headerToken)&&StringUtils.isEmpty(paramToken)){
            log.error("未携带令牌，非法请求");
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

    public static String getOriginalRequestUrl(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        LinkedHashSet<URI> uris = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
        URI requestUri = uris.stream().findFirst().orElse(request.getURI());
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        return UriComponentsBuilder.fromPath(requestUri.getRawPath()).queryParams(queryParams).build().toUriString();
    }
}
