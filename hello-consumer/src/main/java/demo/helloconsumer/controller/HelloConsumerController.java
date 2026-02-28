package demo.helloconsumer.controller;

//import com.alibaba.csp.sentinel.annotation.SentinelResource;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
//import demo.hellocommon.entity.Name;
//import demo.hellocommon.entity.Result;
//import demo.hellocommon.entity.User;
//import demo.hellocommon.service.HelloService;
//import demo.helloconsumer.services.HelloFeignService;
//import demo.helloconsumer.services.impl.MyCallbackListener;
//import jakarta.annotation.PostConstruct;
//import org.apache.dubbo.config.annotation.DubboReference;
//import org.apache.dubbo.config.annotation.Method;
//import org.apache.dubbo.rpc.RpcContext;
import demo.helloconsumer.DTO.AlarmMessage;
import demo.helloconsumer.services.HelloFeignService;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;


@RestController
public class HelloConsumerController {
//    @DubboReference(methods = {@Method(name = "doTask",async = true)})
//    private HelloService helloService;
//    @Value("${server.port}")
//    private String servicePort;
//    @PostConstruct
//    public void init(){
//        helloService.addListener(servicePort,new MyCallbackListener());
//    }
//    @GetMapping("/callback/{username}")
//    public String testCallback(@PathVariable String username){
//        return helloService.sayHello(username,servicePort);
//    }
    @Autowired
    private HelloFeignService helloFeignService;
    private final static Logger logger=LoggerFactory.getLogger(HelloConsumerController.class);
//    @Autowired
//    DiscoveryClient discoveryClient;
//    @Autowired
//    RestTemplate restTemplate;
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//
    @GetMapping("/timeout")
    public String timeout(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "timeout";
    }
    @PostMapping("/notify")
    public void notify(@RequestBody List<AlarmMessage> alarmMessages){
        alarmMessages.forEach(value->{
            System.out.println(value);
        });
    }
    @GetMapping("/sum/{a}/{b}")
    public String sum(@PathVariable int a,@PathVariable int b){
        return Integer.valueOf(add(a,b)).toString();
    }
    @Trace(operationName = "add")
    @Tag(key="arg1",value = "arg[0]")
    @Tag(key = "arg2",value="arg[1]")
    @Tag(key = "result",value = "returnedObj")
    public int add(int a,int b){
        TraceContext.putCorrelation("myKey","myValue");
        Optional<String> op=TraceContext.getCorrelation("myKey");
        logger.info("myKey={}",op.get());
        String traceId=TraceContext.traceId();
        logger.info("traceId={}",traceId);
        return a+b;
    }
    @GetMapping("/enter/{username}")
    public String sayHello(@PathVariable String username){
        logger.info("from sayHello:"+username);
        return helloFeignService.sayHello(username);
    }
//
//    @GetMapping("/enter1/{username}")
//    public String sayHello1(@PathVariable String username){
//        //获取hello-privider-service微服务的所有实例的列表
//        List<ServiceInstance> instances=discoveryClient
//                .getInstances("hello-privider-service");
//        //返回列表中第一个实例的地址http://127.0.0.1:8081
//        String rootUrl=instances.get(0).getUri().toString();
//        String serviceUrl=rootUrl+"/greet/"+username;
//        //访问hello-provider-service微服务
//        ResponseEntity<String> responseEntity=
//                restTemplate.getForEntity(serviceUrl,String.class);
//        //获取响应正文
//        String result=responseEntity.getBody();
//        return result;
//    }
//
//    @GetMapping("/enter2/{username}")
//    public String sayHello2(@PathVariable String username){
//
//        ServiceInstance instance=loadBalancerClient.choose("hello-provider-service");
//        String rootUrl=instance.getUri().toString();
//        String serviceUrl=rootUrl+"/greet/"+username;
//        ResponseEntity<String> responseEntity=restTemplate.getForEntity(serviceUrl,String.class);
//        String result=responseEntity.getBody();
//        return result;
//    }
//
//    @GetMapping("/enter3/{username}")
//    public String sayHello3(@PathVariable String username){
//        String rootUrl="http://hello-provider-service";
//        String serviceUrl=rootUrl+"/greet/"+username;
//
//        ResponseEntity<String> responseEntity=restTemplate.getForEntity(serviceUrl,String.class);
//
//        String result=responseEntity.getBody();
//        return result;
//    }
//
//    @GetMapping("/list")
//    public String showServices(){
//        List<String> services=discoveryClient.getServices();
//        for (String service : services) {
//            System.out.println("服务名："+service);
//        }
//
//        List<ServiceInstance> instances=discoveryClient.getInstances("hello-provider-service");
//        for (ServiceInstance instance : instances) {
//            System.out.println("URI:"+instance.getUri());
//        }
//
//        return "ok";
//    }
//    @GetMapping("/testname")
//    public Result testName(){
//        Name name=new Name("xiaoming","zhang");
//        return helloFeignService.testName(name);
//    }
//    @GetMapping("/testuser")
//    public Result testUser(){
//        Name name=new Name("xiaoming","zhang");
//        User user=new User(1,name);
//        return helloFeignService.testUser(user);
//    }
//    @GetMapping("/enter/{username}")
//    @SentinelResource(value = "sayHello"
////            fallback = "handleException",fallbackClass = MyExceptionHandler.class
////    ,blockHandler = "handleBlock",blockHandlerClass = MyBlockHandler.class
//    )
//    public String sayHello(@PathVariable String username){
////        try {
////            return helloService.sayHello(username);
////        } catch (Exception e) {
////            return username+",something is wrong."
////                    +"<br>"+getStackTrace(e);
////        }
////        return helloService.sayHello(username);
//    }
//    public String handleBlock(String username, BlockException ex){
//        ex.printStackTrace();
//        return username+",request is blocker.";
//    }
    // Sentinel fallback方法
//    public String sayHelloFallback(String username){
//        return username+",服务调用失败，已触发Sentinel熔断降级";
//    }
//    private String getStackTrace(Exception e) {
//        StringWriter sw=new StringWriter();
//        PrintWriter pw=new PrintWriter(sw);
//        try {
//            e.printStackTrace(pw);
//            return sw.toString();
//        } finally {
//            pw.close();
//        }
//    }

//    @GetMapping("/testuser")
//    public Result testUser(){
//        Name name=new Name("xiaoming","zhang");
//        User user=new User(1,name);
//        return helloService.testUser(user);
//    }

//    @GetMapping("/testasync")
//    public String testAsync(){
//        helloService.doTask("保存文件");
//        CompletableFuture<String> helloFuture=
//                RpcContext.getContext().getCompletableFuture();
//        helloFuture.whenComplete((result,exception)->{
//            if(exception==null){
//                System.out.println(result);
//            }else {
//                exception.printStackTrace();
//            }
//        });
//        return "任务已下达";
//    }
}
