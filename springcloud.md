# springcloud
## 一、微服务

### 1.什么是微服务

微服务的核心是将传统的一站式应用根据业务拆分成一个个的微服务，每个服务提供单个功能。

从技术角度上看，微服务类似于线程。有着自己的数据库。

### 2.微服务与微服务架构

微服务强调每个业务模块的功能实现；

微服务架构是一种架构模式，强调服务间的协调配合（通常基于http协议的restful api）

### 3.微服务优缺点

**优点**：

1.每个服务专注于单个业务功能的开发

2.微服务松耦合

3.微服务只是业务逻辑的实现，不会与css，html等界面组件混合

4.每个为服务有自己的存储能力，有自己的数据库

**缺点**：

1.微服务系统的复杂性

2.系统部署依赖

3.服务间通信成本

4.数据一致性

5.系统集成测试

6.性能监控等。。

### 4.微服务相关技术栈

|        微服务条目         |                   落地技术                   |
| :------------------: | :--------------------------------------: |
|         服务开发         |       Springboot、Spring、SpringMVC        |
|       服务配置与管理        |      Netflix公司的Archaius、阿里的Diamond等      |
|       服务注册与发现        |         Eureka、Consul、Zookeeper等         |
|         服务调用         |              Rest、RPC、gRPC               |
|        服务熔断器         |              Hystrix、Envoy等              |
|         负载均衡         |              Ribbon、Nginx等               |
| 服务接口调用(客户端调用服务的简化工具) |                  Feign等                  |
|         消息队列         |         Kafka、RabbitMQ、ActiveMQ等         |
|       服务配置中心管理       |         SpringCloudConfig、Chef等          |
|     服务路由（API网关）      |                  Zuul等                   |
|         服务监控         |     Zabbix、Nagios、Metrics、Spectator等     |
|        全链路追踪         |           Zipkin，Brave、Dapper等           |
|         服务部署         |       Docker、OpenStack、Kubernetes等       |
|       数据流操作开发包       | SpringCloud Stream（封装与Redis,Rabbit、Kafka等发送接收消息） |
|        事件消息总线        |          Spring Cloud Bus......          |

### 5.为什么选择SpringCloud作为微服务架构

微服务是SOA架构思想的扩展。更加强调服务个体的独立性、拆分粒度更小

SOA：面向服务的架构。即根据需求通过网络对松散耦合的粗粒度应用组件进行分布式部署、组合和使用。

**Why SpringCloud？**

- Spring Cloud来源于Spring，质量、稳定性、持续性都可以得到保证
- Spirng Cloud天然支持Spring Boot，更加便于业务落地。
- Spring Cloud发展非常的快
- Spring Cloud是Java领域最适合做微服务的框架。
- 相比于其它框架,Spring Cloud对微服务周边环境的支持力度最大。
- 对于中小企业来讲，使用门槛较低。

## 二、SpringCloud入门概述

### 1.是什么

SpringCloud，基于SpringBoot提供了一套微服务解决方案，包括服务注册与发现，配置中心，全链路监控，服务网关，负载均衡，熔断器等组件，除了基于NetFlix的开源组件做高度抽象封装之外，还有一些选型中立的开源组件。

SpringCloud利用SpringBoot的开发便利性巧妙地简化了分布式系统基础设施的开发，SpringCloud为开发人员提供了快速构建分布式系统的一些工具，包括配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等,它们都可以用SpringBoot的开发风格做到一键启动和部署。

总而言之，SpringCloud是一个分布式微服务架构下的一站式解决方案，是各个微服务架构落地技术的集合体，俗称微服务全家桶。

### 2.SpringCloud 与 SpringBoot

SpringBoot专注于快速、方便的开发单个微服务个体，SpringCloud关注全局的服务治理框架，将SpringBoot开发的一个个单体微服务整合并管理起来。

### 3.※SpringCloud 与 Dubbo

 最大区别：SpringCloud抛弃了Dubbo的RPC通信，采用的是基于HTTP的REST方式。

品牌机与组装机的区别，Spring Cloud的功能比DUBBO更加强大，涵盖面更广

### 4.能干嘛

- Distributed/versioned configuration(分布式/版本控制配置)

- Service registration and discovery(服务注册与发现)

- Routing(路由)

- Service-to-service calls(服务到服务的调用)

- Load balancing(负载均衡配置)

- Circuit Breakers(断路器)

- Distributed messaging(分布式消息管理)

  。。。

### 3.相关资料

官网：http://projects.spring.io/spring-cloud/

https://springcloud.cc/spring-cloud-netflix.html

http://cloud.spring.io/spring-cloud-static/Dalston.SR1/

https://springcloud.cc/spring-cloud-dalston.html

中文社区：http://springcloud.cn/

中文网：https://springcloud.cc/

## 三、工程准备

整体父工程：主要是定义POM文件，将后续各个子模块公用的jar包等统一提出来，类似一个抽象父类

api:公共子模块

provider:微服务提供者

consumer：微服务消费者

## 四、Eureka：服务注册与发现

### 1.是什么

Netflix的一个核心模块。Eureka是一个基于REST的服务，用于定位服务，以实现云端中间层服务发现和故障转移。有了服务发现与注册，只需要使用服务的标识符就可以访问到服务，而不需要修改服务调用的配置文件了。

### 2.原理

 ![eureka](asserts\eureka.png)

**两个组件**：

Eureka Server：提供注册服务，存储可服务节点的信息

Eureka Client：Java客户端，会向Eureka Server发送心跳，内置一个负载均衡器

### 3.使用

**Enureka服务端**

pom依赖：

```xml
<!--eureka-server服务端 -->
   <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-eureka-server</artifactId>
   </dependency>
```

yml依赖：

```yaml
server:
  port: 7001
eureka:
  instance:
    hostname: eureka7001.com #eureka服务端的实例名称
  client:
    register-with-eureka: false     #false表示不向注册中心注册自己。
    fetch-registry: false     #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/       #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址（单机）。
```

主启动类：@EnableEurekaServer

**Eureka客户端：**

pom依赖：

```xml
<!-- 将微服务provider侧注册进eureka -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

yml:

```yaml
eureka:
  client: #客户端注册进eureka服务列表内
    service-url:
      defaultZone: http://localhost:7001/eureka
```

主启动类：@EnableEurekaClient

**其他修改**

（1）访问信息

yml：

```yaml
eureka:
  client: #客户端注册进eureka服务列表内
    service-url:
      defaultZone: http://localhost:7001/eureka
  instance:
    instance-id: shop-provider-dept8001   #访问信息有IP信息提示
    prefer-ip-address: true     #访问路径可以显示IP地址
```

（2）微服务info详细信息

**Eureka客户端**

pom

```xml
<!-- actuator监控信息完善 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

yml：

```yaml
info:
  app.name: shop-springcloud
  company.name: www.pagoda.com
  build.artifactId: ${project.artifactId}
  build.version: ${project.version}
```

### 4.Eureka自我保护

某时刻某一个微服务不可用了，eureka不会立刻清理，依旧会对该微服务的信息进行保存

### 5.Eureka服务发现

对于注册进eureka里面的微服务，可以通过服务发现DiscoveryClient来获得该服务的信息

**代码实现**：

```java
@RestController
public class DeptController {
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("SHOPSPRINGCLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }
}
```


主启动类：@EnableDiscoveryClient

### 6.集群配置

**原理**：

- 处于不同节点的eureka通过Replicate进行数据同步 

- Application Service为服务提供者 

- Application Client为服务消费者 

- Make Remote Call完成一次服务调用

  服务启动后向Eureka注册，Eureka Server会将注册信息向其他Eureka Server进行同步，当服务消费者要调用服务提供者，则向服务注册中心获取服务提供者地址，然后会将服务提供者地址缓存在本地，下次再调用时，则直接从本地缓存中取，完成一次调用。


  当服务注册中心Eureka Server检测到服务提供者因为宕机、网络原因不可用时，则在服务注册中心将服务置为DOWN状态，并把当前服务提供者状态向订阅者发布，订阅过的服务消费者更新本地缓存。


  服务提供者在启动后，周期性（默认30秒）向Eureka Server发送心跳，以证明当前服务是可用状态。Eureka Server在一定的时间（默认90秒）未收到客户端的心跳，则认为服务宕机，注销该实例。

 ![eureka](asserts\eureka.png)

**集群配置**：

Eureka客户端

yml:

```yaml
eureka:
  client: #客户端注册进eureka服务列表内
    service-url:
      #defaultZone: http://localhost:7001/eureka
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
```

Eureka服务端

yml

```yaml
eureka:
  instance:
    hostname: eureka7001.com #eureka服务端的实例名称
  client:
    register-with-eureka: false     #false表示不向注册中心注册自己。
    fetch-registry: false     #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    service-url:
      defaultZone: http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/ #集群
```

### 7.与zookeeper比较

著名的CAP理论指出，一个分布式系统不可能同时满足C(一致性)、A(可用性)和P(分区容错性)。由于分区容错性P在是分布式系统中必须要保证的，因此我们只能在A和C之间进行权衡。
**Zookeeper保证的是CP,Eureka则是AP。**

 **Zookeeper保证CP**

当向注册中心查询服务列表时，我们可以容忍注册中心返回的是几分钟以前的注册信息，但不能接受服务直接down掉不可用。也就是说，服务注册功能对可用性的要求要高于一致性。但是zk会出现这样一种情况，当master节点因为网络故障与其他节点失去联系时，剩余节点会重新进行leader选举。问题在于，选举leader的时间太长，30 ~ 120s, 且选举期间整个zk集群都是不可用的，这就导致在选举期间注册服务瘫痪。在云部署的环境下，因网络问题使得zk集群失去master节点是较大概率会发生的事，虽然服务能够最终恢复，但是漫长的选举时间导致的注册长期不可用是不能容忍的。

**Eureka保证AP**
Eureka看明白了这一点，因此在设计时就优先保证可用性。Eureka各个节点都是平等的，几个节点挂掉不会影响正常节点的工作，剩余的节点依然可以提供注册和查询服务。而Eureka的客户端在向某个Eureka注册或时如果发现连接失败，则会自动切换至其它节点，只要有一台Eureka还在，就能保证注册服务可用(保证可用性)，只不过查到的信息可能不是最新的(不保证强一致性)。除此之外，Eureka还有一种**自我保护机制**，如果在15分钟内超过85%的节点都没有正常的心跳，那么Eureka就认为客户端与注册中心出现了网络故障，此时会出现以下几种情况： 
1. Eureka不再从注册列表中移除因为长时间没收到心跳而应该过期的服务 
2. Eureka仍然能够接受新服务的注册和查询请求，但是不会被同步到其它节点上(即保证当前节点依然可用) 
3. 当网络稳定时，当前实例新的注册信息会被同步到其它节点中

因此， **Eureka可以很好的应对因网络故障导致部分节点失去联系的情况，而不会像zookeeper那样使整个注册服务瘫痪。**

## 五、ribbon

## 六、feign

## 七、hystrix

## 八、zuul

## 九、config

## 十、相关面试题