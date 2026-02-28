package demo.hellogateway;
//
//import lombok.Data;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//@Component
//public class PrintParamGatewayFilterFactory extends AbstractGatewayFilterFactory<PrintParamGatewayFilterFactory.Config> {
//    public PrintParamGatewayFilterFactory(){
//        super(Config.class);
//    }
//    @Override
//    public List<String> shortcutFieldOrder() {
//        return Arrays.asList("param");
//    }
//    @Override
//    public GatewayFilter apply(Config config) {
//        return ((exchange, chain) -> {
//            ServerHttpRequest request=exchange.getRequest();
//            if(request.getQueryParams().containsKey(config.param)){
//                request.getQueryParams()
//                        .get(config.param).forEach((v)->{
//                            System.out.println("请求参数："+config.param+"="+v);
//                        });
//            }
//            return chain.filter(exchange);
//        });
//    }
//    @Data
//    public static class Config{
//        private String param;
//
//    }
//}
