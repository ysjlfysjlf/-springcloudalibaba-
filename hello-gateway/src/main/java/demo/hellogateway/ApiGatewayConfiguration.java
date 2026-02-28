package demo.hellogateway;

import com.alibaba.csp.sentinel.adapter.gateway.common.SentinelGatewayConstants;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPathPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
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

import javax.swing.plaf.PanelUI;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Configuration
public class ApiGatewayConfiguration {
    private final List<ViewResolver> viewResolvers;
    private final ServerCodecConfigurer serverCodecConfigurer;
    public ApiGatewayConfiguration(
            ObjectProvider<List<ViewResolver>> viewResolversProvider,
            ServerCodecConfigurer serverCodecConfigurer
    ){
        this.viewResolvers=viewResolversProvider
                .getIfAvailable(Collections::emptyList);
        this.serverCodecConfigurer=serverCodecConfigurer;
    }
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public GlobalFilter sentinelGatewayFilter(){
        return new SentinelGatewayFilter();
    }
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler(){
        return new SentinelGatewayBlockExceptionHandler(viewResolvers,serverCodecConfigurer);
    }
    @PostConstruct
    public void doInit(){
        initCustomizedApis();
        initGatewayRules();
    }
//初始化自定义的API接口
    private void initGatewayRules() {
        Set<GatewayFlowRule> rules=new HashSet<>();
        rules.add(new GatewayFlowRule("provider-service-api")
                .setResourceMode(SentinelGatewayConstants.RESOURCE_MODE_CUSTOM_API_NAME)
                .setCount(1)
                .setIntervalSec(1));
        rules.add(new GatewayFlowRule("consumer-service-api")
                .setResourceMode(SentinelGatewayConstants.RESOURCE_MODE_CUSTOM_API_NAME)
                .setCount(2)
                .setIntervalSec(1));
        GatewayRuleManager.loadRules(rules);
    }
//初始化限流规则
    private void initCustomizedApis() {
        Set<ApiDefinition> definitions=new HashSet<>();
        ApiDefinition api1=new ApiDefinition("consumer-service-api")
                .setPredicateItems(new HashSet<>(){{
                    add(new ApiPathPredicateItem()
                            .setPattern("/enter/**")
                            .setMatchStrategy(SentinelGatewayConstants.URL_MATCH_STRATEGY_PREFIX));
                    add(new ApiPathPredicateItem()
                            .setPattern("/list"));
                }});
        ApiDefinition api2=new ApiDefinition("provider-service-api")
                .setPredicateItems(new HashSet<>(){{
                    add(new ApiPathPredicateItem()
                            .setPattern("/greet/**")
                            .setMatchStrategy(SentinelGatewayConstants.URL_MATCH_STRATEGY_PREFIX));
                }});
        definitions.add(api1);
        definitions.add(api2);
        GatewayApiDefinitionManager.loadApiDefinitions(definitions);
    }
}
