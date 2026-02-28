package demo.hellogateway;

//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.util.Date;
//
//@Component
//@Slf4j
//public class FlagGatewayFilter implements GlobalFilter, Ordered {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        log.info("FlagGatewayFilter:"+new Date());
//        String flag=exchange.getRequest()
//                .getQueryParams()
//                .getFirst("flag");
//        if(flag==null){
//            log.info("FlagGateWayFilter:falg为null，不允许访问");
//            exchange.getResponse()
//                    .setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//            byte[] response=("Access Refused:"+exchange.getRequest().getPath()).getBytes();
//            DataBuffer wrapResponse=exchange.getResponse()
//                    .bufferFactory().wrap(response);
//            return exchange.getResponse()
//                    .writeWith(Flux.just(wrapResponse));
//        }
//        return chain.filter(exchange);
//    }
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
