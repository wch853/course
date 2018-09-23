### 软件架构
软件架构是在软件的内部，经过综合各种因素的考量、权衡，选择特定的技术，将系统划分成不同的部分并使这些部分相互分工，彼此协作，为用户提供需要的价值。

#### 软件架构影响因素
- 业务需求：需要实现的功能
- 技术栈：选择用于实现功能的技术
- 成本：愿意为开发软件付出的价值
- 组织架构：有哪些部门能为开发提供帮助
- 可扩展性：面向扩展开放
- 可维护性：维护成本

#### 软件架构进化
##### 单体架构
单体架构功能、业务集中在一个发布包里，部署运行在同一个进程中。
- 优势：易于开发、测试、部署、水平扩展
- 劣势：代码膨胀而难以维护，构建、部署成本大，上手周期长，升级现有技术栈困难，对资源的不同需求导致扩展性差
##### 微服务架构
使用一套小服务来开发单个应用的方式，每个服务运行在独立的进程里，一般采用轻量级的通讯机制互联，并且它们可以通过自动化的方式部署。

### 微服务
#### 诞生背景
- 互联网行业快速发展
- 敏捷开发，精益方法深入人心
- 容器技术的成熟
#### 特征
- 单一职责：只把紧密相关的业务放在一起，无关的业务独立出去
- 轻量级通信：微服务之间的通信应该是轻量级的，平台无关，语言无关
- 隔离性：每个微服务运行在自己的进程中，不会相互干扰
- 有自己的数据：有独立的数据存储系统
- 技术多样性：开发人员选用自己擅长的技术栈
#### 优势
- 独立性：微服务构建、部署、扩容、缩容、容错甚至数据库都是独立的
- 敏捷性：微服务功能单一，API简单，迭代方便
- 技术栈灵活：在保证提供稳定服务的情况下微服务各个模块可以自由选择技术栈
- 高效团队：每个团队负责自己的微服务，提高开发效率
#### 不足
- 额外工作：微服务需要考虑如何拆分系统，而单体架构不需要
- 数据一致性：单体架构可能只有一个数据库，通过事务可以保证数据一致性，而微服务有多个数据库
- 沟通成本：服务的提供方和调用方可能属于多个团队，增加了沟通成本
#### 微服务架构引入的问题
##### 通讯
###### 从通讯协议角度考虑
- REST API
- RPC
- MQ
###### 选择RPC框架考虑因素
- I/O、线程调度模型
- 序列化方式
- 是否需要多语言支持
###### 常见RPC框架
![Dubbo](./dubbo.png)
[Dubbo](http://dubbo.apache.org/zh-cn/)是一款高性能的RPC框架。注册中心提供注册和发现服务，而不提供转发请求。消费者订阅提供者在注册中心注册的服务，通过接口调用提供者对服务的具体实现。监控中心服务统计消费者和提供者的调用次数、调用时间等，并在汇总后发给注册中心。

![Motan](./motan.png)
[Motan](https://github.com/weibocom/motan)是新浪微博开源的一个Java RPC框架，目前在微博平台中已经广泛应用，每天为数百个服务完成近千亿次的调用。

![thrift](./thrift.png)
[thrift](http://thrift.apache.org/)是一个跨语言的服务部署框架，通过IDL（Interface Definition Language，接口定义语言）来定义RPC的接口和数据类型，并通过thrift编译器生成不同语言的代码，并由生成的代码负责RPC协议层和传输层的实现。

![gRPC](./grpc.png)
在gRPC里客户端应用可以像调用本地对象一样直接调用另一台不同的机器上服务端应用的方法。在服务端实现接口，并运行一个gRPC服务器处理客户端调用。在客户端拥有一个存根能够像服务端一样调用方法。gRPC同样是跨语言的，使用protobuf进行序列化。

![rpc框架对比](./rpc框架对比.png)

##### 发现
- 客户端发现
![客户端发现](./客户端发现.png)

- 服务端发现
![服务端发现](./服务端发现.png)

##### 部署
传统部署可能通过jenkins脚本上传代码来部署，微服务随着数量增多，传统部署方式部署困难，需要引入服务编排工具，如Mesos、Docker Swarm、Kubernetes。

### 分布式服务实践
以一个简单的课程服务为例，实现用户登录、注册，发送消息验证码，查询课程信息等功能，集成dubbo、thrift、SpringBoot、SpringCloud等框架，并在Docker上进行容器化部署。
![服务架构](./服务架构.png)
- course-thrift-server：基于thrift(Java)，通过TSocket对外提供用户相关服务。
- course-dubbo-server：基于Dubbo，通过注册中心zookeeper注册提供的服务。
- course-message：基于thrift(golang)，通过TSocket对外提供信息相关服务。
- course-web：web服务入口，根据业务逻辑进行RPC调用。
- course-api-gateway：基于SpringCloud zuul的服务网关，通过REST调用course-web的服务，面向客户调用。

![服务依赖](./服务依赖.png)

#### 用户服务
用户服务负责查询和注册用户信息，实现thrift文件生成的java接口，并通过TSocket对外暴露服务。
##### thrift代码生成
编写thrift文件（[thrift语法](http://thrift.apache.org/docs/idl)），下载thrift代码生成工具，使用命令 ```thrift --gen java --out ../course-interface/src/main/java user_model.thrift && thrift  --gen java --out ../course-interface/src/main/java user_service.thrift``` 生成thrift类和接口文件。
```
namespace java com.wch.course.domain.thrift

typedef i32 INT
typedef i64 LONG

/**
 * 用户信息
 */
struct UserInfo {

    /**
     * 用户编号
     */
    1: optional INT id,

    /**
     * 用户名
     */
    2: optional string username,

    /**
     * 密码
     */
    3: optional string password,

    /**
     * 真实姓名
     */
    4: optional string realName,

    /**
     * 手机号
     */
    5: optional LONG mobile,

    /**
     * 电子邮箱
     */
    6: optional string email
}
```
```
namespace java com.wch.course.service.thrift

include 'user_model.thrift'

typedef i32 INT
typedef user_model.UserInfo UserInfo

/**
 * 用户信息服务
 */
service IUserService {

    /**
     * 通过用户编号查询用户信息
     */
    UserInfo queryUserById(1: INT id);

    /**
     * 通过用户名查询用户信息
     */
    UserInfo queryUserByName(1: string username);

    /**
     * 新增用户
     */
    void addUser(1: UserInfo userInfo);
}
```

##### 通过TSocket暴露thrift服务
```
@Slf4j
@Component
public class ThriftServer {

    @Value("${thrift.port}")
    private int thriftServicePort;

    @Resource
    private IUserService.Iface userService;

    @PostConstruct
    public void startThriftServer() {
        TProcessor processor = new IUserService.Processor<>(userService);
        TNonblockingServerSocket socket = null;
        try {
            socket = new TNonblockingServerSocket(thriftServicePort);
        } catch (TTransportException e) {
            log.error("start thrift server error", e);
        }

        TNonblockingServer.Args args = new TNonblockingServer.Args(socket);
        args.processor(processor);
        args.transportFactory(new TFramedTransport.Factory());
        args.protocolFactory(new TBinaryProtocol.Factory());

        TServer server = new TNonblockingServer(args);
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("thrift server start on {} ...", thriftServicePort);
                server.serve();
            }
        }).start();
    }
}
```

#### 课程服务
课程服务负责查询课程信息，实现课程服务并将Dubbo接口注册到zookeeper。
使用dubbo-spring-boot-starter作为dubbo与SpringBoot集成的jar包（SpringBoot 1.x版本只支持dubbo-spring-boot-starter 0.1.1）。为了后期与docker集成，部分参数以占位符的形式存在，而dubbo-spring-boot-starter的自动配置很早就从配置文件中取固定格式的dubbo配置，此时部分参数还是占位符的形式，导致自动配置失败，因此本项目选择自定义配置参数名称，手动编写部分配置替换自动配置。
- 服务端

配置文件：
```
dubbo:
  scan:
    basePackages: com.wch.course.service.impl
  application:
    name: dubbo-provider
  provider:
    port: ${dubbo.port}
  registry: zookeeper://${registry.address}?client=curator
```
配置注册中心和服务项：
```
@Configuration
public class DubboConfig {

    @Value("${dubbo.registry}")
    private String registry;

    @Value("${dubbo.provider.port}")
    private int dubboPort;

    @Bean
    public RegistryConfig registryConfig() {
        return new RegistryConfig(registry);
    }

    @Bean
    public ProtocolConfig dubboProtocolConfig() {
        return new ProtocolConfig("dubbo", dubboPort);
    }
}
```

#### web服务
web服务负责根据业务逻辑进行RPC调用，并向外部暴露REST接口。
##### thrift客户端
```
private TServiceClient getService(String host, int port, int timeout, Class<? extends TServiceClient> clazz) throws Exception {
    TSocket socket = new TSocket(host, port, timeout);
    TFramedTransport transport = new TFramedTransport(socket);
    transport.open();
    TBinaryProtocol tBinaryProtocol = new TBinaryProtocol(transport);
    Constructor<? extends TServiceClient> constructor = clazz.getConstructor(TProtocol.class);
    return constructor.newInstance(tBinaryProtocol);
}

public IUserService.Client getUserService() throws Exception {
    return (IUserService.Client) getService(userServiceHost, userServicePort, timeout, IUserService.Client.class);
}

public IMessageService.Client getMessageService() throws Exception {
    return (IMessageService.Client) getService(messageServiceHost, messageServicePort, timeout, IMessageService.Client.class);
}
```
##### dubbo客户端配置
配置文件：
```
dubbo:
  application:
    name: dubbo-consumer
  registry: zookeeper://${registry.address}?client=curator
```
配置注册中心：
```
@Configuration
public class DubboConfig {

    @Value("${dubbo.registry}")
    private String registry;

    @Bean
    public RegistryConfig registryConfig() {
        return new RegistryConfig(registry);
    }
}
```

#### APIGateway
APIGateway基于SpringCloud zuul向外暴露REST接口。
配置文件：
```
zuul:
  routes:
    course:
      path: /course/**
      url: http://localhost:8080/course-web/course/
    user:
      path: /user/**
      url: http://localhost:8080/course-web/user/
    message:
      path: /message/**
      url: http://localhost:8080/course-web/message/
```

#### 构建docker镜像
对各服务模块进行打包后编写Dockerfile：
```
FROM openjdk:8-jre-slim
LABEL maintainer="wch wch@163.com"

COPY target/course-web-1.0-SNAPSHOT.jar /course-web.jar

ENTRYPOINT ["java", "-jar", "/course-web.jar"]
```

#### 编写docker-compose文件
各镜像构建完成后编写docker-compose文件来方便编排docker服务。
```
version: '3'

services:
  zookeeper:
    image: zookeeper:3.4.13
    networks:
      - rpc-bridge

  redis:
    image: redis:latest
    command:
      - "--appendonly yes"
    volumes:
      - d:/docker/redis:/data
    networks:
      - component-bridge

  mysql:
    image: mysql:5.7
    environment:
      MYSQL_ROOT_PASSWORD: admin
      MYSQL_ROOT_HOST: "%"
    volumes:
      - d:/docker/mysql/data:/var/lib/mysql
      - d:/docker/mysql/conf/my.cnf:/etc/mysql/my.cnf
    networks:
      - data-bridge

  thrift-server:
    image: course-thrift-server:1.0
    links:
      - mysql
    command:
      - "--spring.profiles.active=prd"
      - "--rpc.thrift.port=8081"
      - "--mysql.address=mysql:3306"
    networks:
      - rpc-bridge
      - data-bridge

  dubbo-server:
    image: course-dubbo-server:1.0
    links:
      - zookeeper
      - mysql
    command:
      - "--spring.profiles.active=prd"
      - "--dubbo.port=8083"
      - "--registry.address=zookeeper:2181"
      - "--mysql.address=mysql:3306"
    networks:
      - rpc-bridge
      - data-bridge

  web:
    image: course-web:1.0
    links:
      - redis
      - zookeeper
      - thrift-server
    volumes:
      - d:/docker/app/logs/course-web:/var/app/logs/course-web
    command:
      - "--spring.profiles.active=prd"
      - "--server.port=8080"
      - "--thrift.service.user.host=thrift-server"
      - "--thrift.service.user.port=8081"
      - "--redis.host=redis"
      - "--redis.port=6379"
      - "--registry.address=zookeeper:2181"
    networks:
      - rpc-bridge
      - component-bridge
      - net-bridge

  api-gateway:
    image: course-api-gateway:1.0
    links:
      - web
    command:
      - "--spring.profiles.active=prd"
      - "--server.port=80"
      - "--web.host=web"
      - "--web.port=8080"
    ports:
      - 80:80
    networks:
      - net-bridge

networks:
  net-bridge:
    driver: bridge
  component-bridge:
    driver: bridge
  data-bridge:
    driver: bridge
  rpc-bridge:
    driver: bridge
```

#### 运行和管理docker服务
```
# 启动
docker-compose up -d
# 对dubbo-server进行扩容
docker-compose up --scale dubbo-server=3 -d
# 关闭并删除所有容器
docker-compose down
```

### 故障
#### Docker for Windows暴露连接端口
本地使用Docker for Windows，运行docker version命令，客户端报错，需要勾选Expose daemon on tcp://localhost:2375 without TLS。
![Docker for Windows暴露连接端口](./Docker for Windows暴露连接端口.png)

#### Docker for Windows共享本地硬盘设置不生效
修改本地共享安全策略后选择共享给Docker的硬盘。
![Docker本地共享安全设置.png](./Docker本地共享安全设置.png)
![Docker选择共享本地硬盘.png](./Docker选择共享本地硬盘.png)

#### MySQL默认禁止远程连接
MySQL默认禁止远程连接，需要配置docker容器连接用户的远程连接权限。
- 安装的mysql
```
grant all privileges on *.* to 'root'@'%' identified by 'pwd';
flush privileges;
# 查看指定用户是否改为不限制IP登录
SELECT user, host FROM mysql.user;
```
- docker提供的mysql镜像
docker启动参数中使用-e MYSQL_ROOT_HOST=%
```
docker run -d -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_ROOT_HOST=% -p 3307:3306 -v d:/docker/mysql/conf/my.cnf:/etc/mysql/my.cnf -v d:/docker/mysql/data:/var/lib/mysql --name=mysql mysql:5.7
```
#### redis-windows默认绑定本地
在redis配置文件中，配置 bind 127.0.0.1 表示redis限制本地连接，windows版本默认是开启的，docker容器进行连接时需要注释此配置、
#### redis设置密码错误
拉取的redis镜像默认没有配置密码，若配置文件中填写了密码进行连接会保错。在上docker版本的配置文件中通过配置默认值，即：
```
spring.redis.password=
```
来覆盖密码配置。
#### mysql容器ssl连接错误
使用java客户端连接mysql容器出错，seSSL参数修改为false。
```
jdbc:mysql://${mysql.address}/test?useUnicode=true&characterEncoding=utf8&useSSL=false
```