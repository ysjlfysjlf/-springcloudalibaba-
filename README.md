孙卫琴的《springcloudalibaba从入门到实战》从0到1构建项目，以及35页学习笔记，包含springcloudalibaba全家桶知识，里面有全面的学习笔记和过程截图。文档为pdf格式
###SpringCloudAlibaba框架概述：
  SpringCloudAlibaba框架的“全家桶套餐”
  微服务注册中心：Nacos
  微服务配置中心：Nacos
  负载均衡器：LoadBalancer
  远程调用框架及组件：Dubbo和OpenFeign
  流量控制组件：Sentinel
  网关组件：Gateway
  消息驱动框架及消息中间件：Stream和RocketMQ
  链路追踪组件：SkyWalking
  分布式事务管理组件：Seata
###示例：搭建Nginx+Nacos集群：
（1）克隆三台ubuntu
<img width="480" height="416" alt="image" src="https://github.com/user-attachments/assets/48875946-411b-4ce6-8e82-9b342d534acf" />
（2）配置nginx

<img width="543" height="442" alt="image" src="https://github.com/user-attachments/assets/ff9fc116-769b-4875-834d-7f932cff77b5" />
（3）访问nacos集群

<img width="1506" height="1049" alt="image" src="https://github.com/user-attachments/assets/8c25489d-770e-45ce-90b0-9d622ad24410" />
###示例：搭建Redis集群：
（1）在redis安装目录下创建redis.conf文件，配置监听端口、开启集群功能等

<img width="785" height="701" alt="image" src="https://github.com/user-attachments/assets/3a3ba039-36f4-4491-b240-a34d500f3be1" />
（2）把redis1目录复制为redis2、redis3、redis4、redis5、redis6，并修改redis.conf下的端口和node-700*.conf配置
（3）启动6个Redis服务，运行以下命令

<img width="2324" height="1029" alt="image" src="https://github.com/user-attachments/assets/49652692-911d-44b7-be67-f770dbe77f7a" />
（4）在微服务中使用Redis集群

<img width="2348" height="504" alt="image" src="https://github.com/user-attachments/assets/57cf1cec-71cb-4761-8fa3-27f54a260e86" />






