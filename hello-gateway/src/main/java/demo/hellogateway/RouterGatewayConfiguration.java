package demo.hellogateway;

import com.alibaba.csp.sentinel.adapter.gateway.common.SentinelGatewayConstants;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayParamFlowItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//
//@Configuration
//public class RouterGatewayConfiguration {
//    private final List<ViewResolver> viewResolvers;
//    private final ServerCodecConfigurer serverCodecConfigurer;
//    public RouterGatewayConfiguration(
//            ObjectProvider<List<ViewResolver>> viewResolverProvider,
//            ServerCodecConfigurer serverCodecConfigurer
//    ){
//        this.viewResolvers=viewResolverProvider.getIfAvailable(Collections::emptyList);
//        this.serverCodecConfigurer=serverCodecConfigurer;
//    }
//    @Bean("RouterSentinelGatewayFilter")
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public GlobalFilter sentinelGatewayFilter(){
//        return new SentinelGatewayFilter();
//    }
//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler(){
//        return new SentinelGatewayBlockExceptionHandler(viewResolvers,serverCodecConfigurer);
//    }
//    @PostConstruct
//    public void initGatewayRules(){
//        Set<GatewayFlowRule> rules=new HashSet<>();
//
//        rules.add(new GatewayFlowRule("provider-route")
//                .setResourceMode(
//                        SentinelGatewayConstants.RESOURCE_MODE_ROUTE_ID)
//                .setCount(1)
//                .setIntervalSec(1)
//                .setParamItem(new GatewayParamFlowItem()
//                        .setParseStrategy(SentinelGatewayConstants
//                                .PARAM_PARSE_STRATEGY_URL_PARAM)
//                        .setFieldName("age")));
//        GatewayRuleManager.loadRules(rules);
//    }
//}
