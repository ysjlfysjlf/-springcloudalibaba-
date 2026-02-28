package demo.helloprovider.controller;

//import com.alibaba.csp.sentinel.annotation.SentinelResource;
//import demo.hellocommon.entity.Name;
//import demo.hellocommon.entity.Result;
//import demo.hellocommon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.cglib.core.internal.Function;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;

@RestController
public class HelloProviderController {
    @Value("${server.port}")
    private String servicePort;
    @Value("${spring.application.name}")
    private String serviceName;
    @Autowired
    private StreamBridge streamBridge;
    @PostMapping("/submit")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendBody(@RequestBody String body){
        System.out.println("Sending"+body);
        streamBridge.send("service-out-0",body);
    }

    @GetMapping("/send/{username}")
    public String sendMessage(@PathVariable String username){
        System.out.println("Sending"+username);
        String jsonData="{\"username\":\""+username+"\"}";
        boolean isSucceed=streamBridge.send("mymsg-out-0",jsonData);
        return isSucceed?"success":"error";
    }

//    @SentinelResource("enter")
    @GetMapping("/greet/{username}")
    public String greet(@PathVariable String username) throws IllegalAccessException {
//        return "Hello, " + username +
//                "<br>Service Name:"+serviceName+
//                "<br>Service Port:"+servicePort;

//        try {
//            TimeUnit.SECONDS.sleep(60);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "Hello,"+username;

        if(username!=null&&username.equals("Monster"))
            throw new IllegalAccessException(username);
        return "Hello,"+username;
    }
    @Bean
    public Function<Flux<String>,Flux<String> >reactiveUpperCase(){
        return value->value.map(String::toUpperCase);
    }

//    @GetMapping("/user/testname")
//    public Result testName(@SpringQueryMap Name name){
//        System.out.println("firstname:"+name.getFirstname()
//        +",lastName:"+name.getLastname());
//        return new Result(100,"OK");
//    }
//
//    @PostMapping("/user/testuser")
//    public Result testUser(@RequestBody User user){
//        System.out.println("id:"+user.getId()
//        +",name:"+user.getName().getFirstname()
//        +" "+user.getName().getLastname());
//        return new Result(100,"OK");
//    }
}
