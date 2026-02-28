package demo.helloprovider;

//import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.function.Supplier;

//@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication
public class HelloProviderApplication {
    static int index=0;
    @Bean
    public Supplier<Date> mydate(){
        return ()->new Date();
    }
    @Bean
    public Supplier<Message<Date>> msgs(){
        return ()->{
            Message<Date> message=MessageBuilder
                    .withPayload(new Date())
                    .setHeader("index",index++)
                    .build();
            return message;
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloProviderApplication.class, args);
    }

}
