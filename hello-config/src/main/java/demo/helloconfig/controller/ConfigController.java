package demo.helloconfig.controller;

//import demo.helloconfig.entity.MyProperties;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class ConfigController {
//    @Value("${db.username}")
//    private String username;
//    @Value("${db.password}")
//    private String password;
//    @Autowired
//    private MyProperties myProperties;
//
//    @GetMapping("/config1")
//    public String getConfig1(){
//        return "db.username="+username+",db.password="+password;
//    }
//
//    @GetMapping("/config2")
//    public String getConfig2(){
//        return "db.username="+myProperties.getUsername()+
//                ",db.password="+myProperties.getPassword();
//    }
//
//
//}
