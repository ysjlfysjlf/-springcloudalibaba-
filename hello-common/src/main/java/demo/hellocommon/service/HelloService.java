package demo.hellocommon.service;

import demo.hellocommon.entity.Result;
import demo.hellocommon.entity.User;

public interface HelloService {
    public String sayHello(String username);
    public Result testUser(User user);
    public String sayHello(String username,String key);
    public void addListener(String key,CallbackListener listener);
    public String doTask(String longtask);
}
