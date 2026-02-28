package demo.hellogateway;
//
//import io.micrometer.common.util.StringUtils;
//import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.server.ServerWebExchange;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.function.Predicate;
//
//
//@Component
//public class AgeRoutePredicateFactory
//extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config> {
//
//
//    public AgeRoutePredicateFactory() {
//        super(AgeRoutePredicateFactory.Config.class);
//    }
//
//    @Override
//    public List<String> shortcutFieldOrder() {
//        return Arrays.asList("minAge","maxAge");
//    }
//
//    @Override
//    public Predicate<ServerWebExchange> apply(Config config) {
//        return exchange->{
//            String age=exchange.getRequest()
//                    .getQueryParams().getFirst("age");
//            if(StringUtils.isNotEmpty(age)){
//                try {
//                    int a=Integer.parseInt(age);
//                    boolean res=a>=config.minAge&&a<=config.maxAge;
//                    return res;
//                } catch (NumberFormatException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//            return false;
//        };
//    }
//
//    @Validated
//    public static class Config{
//        private Integer minAge;
//        private Integer maxAge;
//        public Integer getMinAge(){return minAge;}
//        public void setMinAge(Integer minAge){this.minAge=minAge;}
//        public Integer getMaxAge(){return maxAge;}
//        public void setMaxAge(Integer maxAge){this.maxAge=maxAge;}
//
//    }
//}
