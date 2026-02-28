package demo.helloconsumer.services;
//
//import demo.hellocommon.entity.Name;
//import demo.hellocommon.entity.Result;
//import demo.hellocommon.entity.User;
//import demo.helloconsumer.config.HelloFeignConfig;
//import demo.helloconsumer.services.impl.HelloFeignFallback;
//import demo.helloconsumer.services.impl.HelloFeignFallbackFactory;
import demo.helloconsumer.config.HelloFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "hello-provider-service"
//        ,path = "/user")
//        configuration = HelloFeignConfig.class,
//fallbackFactory = HelloFeignFallbackFactory.class
)
public interface HelloFeignService {
//    @GetMapping("/testname")
//    public Result testName(@SpringQueryMap Name name);
    @GetMapping("/greet/{username}")
    public String sayHello(@PathVariable("username") String username);
//    @PostMapping("/testuser")
//    public Result testUser(@RequestBody User user);
}
