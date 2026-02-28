package demo.helloprovider.service.impl;

//import com.alibaba.csp.sentinel.annotation.SentinelResource;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
//import demo.hellocommon.entity.Name;
//import demo.hellocommon.entity.Result;
//import demo.hellocommon.entity.User;
//import demo.hellocommon.service.CallbackListener;
//import demo.hellocommon.service.HelloService;
//import org.apache.dubbo.config.annotation.Argument;
//import org.apache.dubbo.config.annotation.DubboService;
//import org.apache.dubbo.config.annotation.Method;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//@DubboService(loadbalance = "roundrobin",methods = {
//        @Method(name = "addListener",
//        arguments = {@Argument(index = 1,callback = true)})
//},timeout = 10000)
//public class HelloServiceImpl implements HelloService {
//    private final Map<String,CallbackListener> listeners=
//            new ConcurrentHashMap<>();
//    public HelloServiceImpl(){
//        Thread t=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    try {
//                    for (Map.Entry<String, CallbackListener> entry : listeners.entrySet()) {
//                        try {
//                            entry.getValue().report("当前时间："+new Date());
//                        } catch (Exception e) {
//                            listeners.remove(entry.getKey());
//                        }
//                    }
//                        Thread.sleep(5000);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//            }
//        });
//        t.setDaemon(true);//作为后台线程运行
//        t.start();
//    }
//    @Value("${server.port}")
//    private String servicePort;
//    @Value("${spring.application.name}")
//    private String serviceName;
//
//
//    @Override
//    @SentinelResource(value = "say",
//            blockHandler = "handleBlock")
//    public String sayHello(String username) {
//        return "Hello,"+username
//                +"<br>Service Name:"+serviceName
//                +"<br>Service Port:"+servicePort;
//    }
//    public String handleBlock(String username, BlockException ex){
//        ex.printStackTrace();
//        return username+",request is blocker.";
//    }
//
//    @Override
//    public Result testUser(User user) {
//        System.out.println("id:"+user.getId()
//        +",name:"+user.getName().getFirstname()
//        +" "+user.getName().getLastname());
//        return new Result(100,"OK");
//    }

//    @Override
//    public String sayHello(String username, String key) {
//       CallbackListener listener=listeners.get(key);
//       listener.report(username+"打过招呼。");
//       return "Hello,"+username;
//    }

//    @Override
//    public void addListener(String key, CallbackListener listener) {
//        listeners.put(key,listener);
//    }

//    @Override
//    public String doTask(String longtask) {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return longtask+"已经完成";
//    }
//}
