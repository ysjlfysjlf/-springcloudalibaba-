package demo.helloconsumer;

//import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.function.Consumer;

@EnableFeignClients
//@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication
//@Configuration
public class HelloConsumerApplication {
    @Bean
    public Consumer<String> mybody(){
        return body->{
            System.out.println("Received:"+body);
        };
    }
    @Bean
    public Consumer<Person> mymsg(){
        return person->{
            System.out.println("Received:"+person);
        };
    }
    @Data
    public static class Person{
        private String username;
        @Override
        public String toString() {
            return this.username;
        }
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Bean
    public Consumer<Date> mydate(){
        return date->{
            System.out.println("Received: "+date);
        };
    }
    @Bean
    public Consumer<Message<Date>> msgs(){
        return message->{
            System.out.println("Received: "+message.getHeaders());
            System.out.println("Received: "+message.getPayload());
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloConsumerApplication.class, args);
    }

}
