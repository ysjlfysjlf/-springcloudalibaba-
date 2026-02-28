package demo.helloconsumer.services.impl;

//import demo.hellocommon.entity.Name;
//import demo.hellocommon.entity.Result;
//import demo.hellocommon.entity.User;
//import demo.helloconsumer.services.HelloFeignService;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.io.PrintWriter;
//import java.io.StringWriter;
//
//@Component
//public class HelloFeignFallback implements HelloFeignService {
//    private Throwable cause;
//    public HelloFeignFallback(){}
//    public HelloFeignFallback(Throwable cause){
//        this.cause=cause;
//    }
//
//    @Override
//    public Result testName(Name name) {
//        return new Result(404,"testName fallback");
//    }
//
//    @Override
//    public String sayHello(@PathVariable("username") String username) {
//        return username+",something is wrong."
//                +"<br>"+getStackTrace(cause);//输出异常信息
//    }
//
//    @Override
//    public Result testUser(User user) {
//        return new Result(404,"testUser fallback");
//    }
//
//    private String getStackTrace(Throwable cause) {
//        StringWriter sw=new StringWriter();
//        PrintWriter pw=new PrintWriter(sw);
//        try {
//            cause.printStackTrace(pw);
//            return sw.toString();
//        } finally {
//            pw.close();
//        }
//    }
//}
