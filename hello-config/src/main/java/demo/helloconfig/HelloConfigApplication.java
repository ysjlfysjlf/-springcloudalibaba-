package demo.helloconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class HelloConfigApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(HelloConfigApplication.class, args);
        while (true){
            //
            String username=applicationContext
                    .getEnvironment()
                    .getProperty("db.username");
            String password=applicationContext
                    .getEnvironment()
                    .getProperty("db.password");
            String host=applicationContext.getEnvironment().getProperty("db.host");

            System.out.println("db.username="+username+",db.password="+password+
                    ",db.host="+host);
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
