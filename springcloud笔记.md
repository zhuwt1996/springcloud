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

## 四、Eureka 服务注册与发现

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

### 7.※与zookeeper比较

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

## 五、Ribbon 负载均衡

### 1.是什么

Spring Cloud Ribbon是基于Netflix Ribbon实现的一套**客户端       负载均衡**的工具。

**负载均衡**：

**集中式**：在服务的消费方和提供方之间使用独立的LB设施(可以是硬件，如F5, 也可以是软件，如nginx), 由该设施负责把访问请求通过某种策略转发至服务的提供方；

**进程式**：将LB逻辑集成到消费方，消费方从服务注册中心获知有哪些地址可用，然后自己再从这些地址中选择出一个合适的服务器。

Ribbon就属于进程内LB，它只是一个类库，集成于消费方进程，消费方通过它来获取到服务提供方的地址。

官方网址：https://github.com/Netflix/ribbon/wiki/Getting-Started

### 2.初步配置

pom

```xml
<!-- Ribbon相关 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-ribbon</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

调用服务端对象添加@LoadBalanced

```java
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
```

结论：**Ribbon和Eureka整合后Consumer可以直接调用服务而不用再关心地址和端口号**

### 3.Ribbon负载均衡

**工作原理**

Ribbon在工作时分成两步
第一步先选择 EurekaServer ,它优先选择在同一个区域内负载较少的server.
第二步再根据用户指定的策略，在从server取到的服务注册列表中选择一个地址。
其中Ribbon提供了多种策略：比如轮询、随机和根据响应时间加权。

总结：Ribbon其实就是一个软负载均衡的客户端组件，
他可以和其他所需请求的客户端结合使用，和eureka结合只是其中的一个实例。

### 4.核心组件IRule

**IRule**：**根据特定算法中从服务列表中选取一个要访问的服务**

**RoundRobinRule**     轮询

**RandomRule**    随机

**AvailabilityFilteringRule**    

  会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，
还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问

**WeightedResponseTimeRule**

根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高。
刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够，
会切换到WeightedResponseTimeRule

**RetryRule**

先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务

**BestAvailableRule**

会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务

**ZoneAvoidanceRule**

默认规则,复合判断server所在区域的性能和server的可用性选择服务器

5.自定义Ribbon

主启动类：**@RibbonClient**

**配置细节** ：这个自定义配置类不能放在@ComponentScan所扫描的当前包下以及子包下，
否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，也就是说
我们达不到特殊化定制的目的了。（**配置类所在包不跟主启动类在一个目录下**）

```java
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule()
    {
        return new RandomRule();// Ribbon默认是轮询，我自定义为随机
    }
}
```

主启动类：**@RibbonClient(name="SHOPSPRINGCLOUD-DEPT",configuration= MySelfRule.class)**

需求：每个服务器要求被调用5次。也即以前是每台机器一次，现在是每台机器5次

解析源码：https://github.com/Netflix/ribbon/blob/master/ribbon-loadbalancer/src/main/java/com/netflix/loadbalancer/RandomRule.java

MySelfRule：return new RandomRule_ZWT();// 我自定义为每台机器5次

RandomRule_ZWT：

```java
public class RandomRule_ZWT extends AbstractLoadBalancerRule {
    // total = 0 // 当total==5以后，我们指针才能往下走，
    // index = 0 // 当前对外提供服务的服务器地址，
    // total需要重新置为零，但是已经达到过一个5次，我们的index = 1
    // 分析：我们5次，但是微服务只有8001 8002 8003 三台，OK？
    //
    private int total = 0;           // 总共被调用的次数，目前要求每台被调用5次
    private int currentIndex = 0;  // 当前提供服务的机器号

    public Server choose(ILoadBalancer lb, Object key)
    {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes only get more
                 * restrictive.
                 */
                return null;
            }

//       int index = rand.nextInt(serverCount);// java.util.Random().nextInt(3);
//       server = upList.get(index);


//       private int total = 0;           // 总共被调用的次数，目前要求每台被调用5次
//       private int currentIndex = 0;  // 当前提供服务的机器号
            if(total < 5)
            {
                server = upList.get(currentIndex);
                total++;
            }else {
                total = 0;
                currentIndex++;
                if(currentIndex >= upList.size())
                {
                    currentIndex = 0;
                }
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were somehow trimmed.
                 * This is a transient condition. Retry after yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }
        return server;
    }
   ...
}
```

## 六、Feign 负载均衡

### 1.是什么

官网解释：
http://projects.spring.io/spring-cloud/spring-cloud.html#spring-cloud-feign

 Feign是一个**声明式WebService客户端**。使用Feign能让编写Web Service客户端更加简单, 它的使用方法是**定义一个接口，然后在上面添加注解**，同时也支持JAX-RS标准的注解。Feign也支持可拔插式的编码器和解码器。Spring Cloud对Feign进行了封装，使其支持了Spring MVC标准注解和HttpMessageConverters。Feign可以与Eureka和Ribbon组合使用以支持负载均衡。

 Feign是一个声明式的Web服务客户端，使得编写Web服务客户端变得非常容易，
只需要创建一个接口，然后在上面添加注解即可。
参考官网：https://github.com/OpenFeign/feign 

### 2.能干嘛

Feign旨在使编写Java Http客户端变得更容易。
前面在使用Ribbon+RestTemplate时，利用RestTemplate对http请求的封装处理，形成了一套模版化的调用方法。但是在实际开发中，由于对服务依赖的调用可能不止一处，往往一个接口会被多处调用，所以通常都会针对每个微服务自行封装一些客户端类来包装这些依赖服务的调用。所以，Feign在此基础上做了进一步封装，由他来**实现依赖服务接口的定义**。在Feign的实现下，我们**只需创建一个接口并使用注解的方式来配置它**(以前是Dao接口上面标注Mapper注解,现在是一个微服务接口上面标注一个Feign注解即可)，即可**完成对服务提供方的接口绑定**，简化了使用Spring cloud Ribbon时，自动封装服务调用客户端的开发量。

Feign集成了Ribbon
利用Ribbon维护了MicroServiceCloud-Dept的服务列表信息，并且通过轮询实现了客户端的负载均衡。而与Ribbon不同的是，通过feign**只需要定义服务绑定接口且以声明式的方法**，优雅而简单的实现了服务调用

### 3.使用

**pom**

```xml
<!-- feign相关 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-feign</artifactId>
</dependency>
```

服务提供方：提供的service添加注解**@FeignClient**

服务消费方：主程序添加注解**@EnableFeignClients**

总结：

  **Feign通过接口的方法调用Rest服务**（之前是Ribbon+RestTemplate），该请求发送给Eureka服务器（http://MICROSERVICECLOUD-DEPT/dept/list）,通过Feign直接找到服务接口，由于**在进行服务调用的时候融合了Ribbon技术，所以也支持负载均衡作用。**

## 七、Hystrix 断路器

### 1.分布式系统面临的问题

**服务雪崩**

多个微服务之间调用的时候，假设微服务A调用微服务B和微服务C，微服务B和微服务C又调用其它的微服务，这就是所谓的**“扇出”**。如果扇出的链路上某个微服务的调用响应时间过长或者不可用，对微服务A的调用就会占用越来越多的系统资源，进而引起系统崩溃，所谓的**“雪崩效应”.**

对于高流量的应用来说，单一的后端依赖可能会导致所有服务器上的所有资源都在几秒钟内饱和。比失败更糟糕的是，这些应用程序还可能导致服务之间的延迟增加，备份队列，线程和其他系统资源紧张，导致整个系统发生更多的级联故障。这些都表示需要对故障和延迟进行隔离和管理，以便单个依赖关系的失败，不能取消整个应用程序或系统。

**解决方案**

（1）**熔断模式**：如果某个目标服务调用慢或者有大量超时，此时，熔断该服务的调用，对于后续调用请求，不在继续调用目标服务，直接返回，快速释放资源。如果目标服务情况好转则恢复调用。


（2）**隔离模式**：这种模式就像对系统请求按类型划分成一个个小岛的一样，当某个小岛被火少光了，不会影响到其他的小岛。例如可以对不同类型的请求使用线程池来资源隔离，每种类型的请求互不影响，如果一种类型的请求线程资源耗尽，则对后续的该类型请求直接返回，不再调用后续资源。这种模式使用场景非常多，例如将一个服务拆开，对于重要的服务使用单独服务器来部署。

（3）**限流模式**：上述的熔断模式和隔离模式都属于出错后的容错处理机制，而限流模式则可以称为**预防模式**。限流模式主要是提前对各个类型的请求设置最高的QPS阈值，若高于设置的阈值则对该请求直接返回，不再调用后续资源。这种模式不能解决服务依赖的问题，只能解决系统整体资源分配问题，因为没有被限流的请求依然有可能造成雪崩效应。

### 2.是什么

Hystrix是一个**用于处理分布式系统的延迟和容错的开源库**，在分布式系统里，许多依赖不可避免的会调用失败，比如超时、异常等，Hystrix能够**保证在一个依赖出问题的情况下，不会导致整体服务失败，避免级联故障，以提高分布式系统的弹性。**

“断路器”本身是一种开关装置，当某个服务单元发生故障之后，通**过断路器的故障监控（类似熔断保险丝），向调用方返回一个符合预期的、可处理的备选响应（FallBack），而不是长时间的等待或者抛出调用方无法处理的异常**，这样就保证了服务调用方的线程不会被长时间、不必要地占用，从而避免了故障在分布式系统中的蔓延，乃至雪崩。

官网资料：https://github.com/Netflix/Hystrix/wiki/How-To-Use

功能：**服务降级，服务熔断，服务限流，接近实时的监控**

### 3.服务熔断

熔断机制是应对雪崩效应的一种微服务链路**保护机制**。
当扇出链路的某个微服务不可用或者响应时间太长时，会进行服务的降级，进而**熔断该节点微服务的调用，快速返回"错误"的响应信息。**当检测到该节点微服务调用响应正常后恢复调用链路。在SpringCloud框架里熔断机制通过Hystrix实现。**Hystrix会监控微服务间调用的状况，当失败的调用到一定阈值，缺省是5秒内20次调用失败就会启动熔断机制。**熔断机制的注解是**@HystrixCommand**。

pom

```xml
<!-- hystrix -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>
```

**一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法**

```java
@RestController
public class DeptController {
    @Autowired
    private DeptService service = null;

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id)
    {

        Dept dept = this.service.get(id);

        if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }

        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id)
    {
        return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }

}
```

主启动类：**@EnableCircuitBreaker**

### 4.服务降级

**整体资源快不够了，忍痛将某些服务先关掉，待渡过难关，再开启回来。**

**服务降级处理是在客户端实现完成的，与服务端没有关系**

```java
@Component    //不能缺省
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id)
            {
                return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDb_source("no this database in MySQL");
            }
          ...
        };
    }
}
```

service接口：

**@FeignClient(value = "SHOPSPRINGCLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)**

yml开启hystrix

```yaml
feign:
  hystrix:
    enabled: true
```

服务端provider down以后，由于服务降级，让客户端在服务端不可用时也会获得提示信息而不会挂起耗死服务器

### 5.服务监控Hystrix DashBoard

除了隔离依赖服务的调用以外，Hystrix还提供了准实时的调用监控（Hystrix Dashboard），Hystrix会**持续地记录所有通过Hystrix发起的请求的执行信息，并以统计报表和图形的形式展示给用户，包括每秒执行多少请求多少成功，多少失败等。**Netflix通过hystrix-metrics-event-stream项目实现了对以上指标的监控。Spring Cloud也提供了Hystrix Dashboard的整合，对监控内容转化成可视化界面。

pom

```xml
<!-- hystrix和 hystrix-dashboard相关 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
</dependency>
```

客户端：**@EnableHystrixDashboard**

所有Provider微服务提供类都需要监控依赖配置

http://localhost:8001/hystrix.stream监控窗口参数：

**填写监控地址**

1.Delay：该参数用来控制服务器上轮询监控信息的延迟时间，默认为2000毫秒，可以通过配置该属性来降低客户端的网络和CPU消耗。

2.Title：该参数对应了头部标题Hystrix Stream之后的内容，默认会使用具体监控实例的URL，可以通过配置该信息来展示更合适的标题。

实心圆：共有两种含义。它通过颜色的变化代表了实例的**健康程度**，它的健康度从**绿色<黄色<橙色<红色**递减。
该实心圆除了颜色的变化之外，它的大小也会根据实例的请求流量发生变化，**流量越大该实心圆就越大**。所以通过该实心圆的展示，就可以在大量的实例中快速的发现故障实例和高压力实例。

曲线：用来记录**2分钟内流量的相对变化**，可以通过它来观察到流量的上升和下降趋势。

## 八、Zuul 路由网关

### 1.是什么

Zuul包含了对请求的**路由和过滤**两个最主要的功能。其中路由功能负责将外部请求转发到具体的微服务实例上，是**实现外部访问统一入口**的基础而过滤器功能则负责对请求的处理过程进行干预，是实现请求校验、服务聚合等功能的基础.Zuul和Eureka进行整合，将Zuul自身注册为Eureka服务治理下的应用，同时从Eureka中获得其他微服务的消息，也即以后的访问微服务都是通过Zuul跳转后获得。

注意：Zuul服务最终还是会注册进Eureka

提供=**代理+路由+过滤**三大功能

官网资料：https://github.com/Netflix/zuul/wiki/Getting-Started

### 2.路由基本配置

pom

```xml
<!-- zuul路由网关 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zuul</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
```

主启动类：**@EnableZuulProxy**

### 3.路由访问映射规则

**代理名称：**

```yaml
zuul:
  routes:
    mydept.serviceId: shopspringcloud-dept
    mydept.path: /mydept/**
```

before
http://myzuul.com:9527/microservicecloud-dept/dept/get/2

after
http://myzuul.com:9527/mydept/dept/get/1

**原真实服务名忽略**

```yaml
zuul:
  ignored-services: shopspringcloud-dept
```

单个具体，多个可以用"*"

**设置统一公共前缀**

```yaml
zuul:
  prefix: /pagoda
```

## 九、Config 分布式配置中心

### 1.概述

分布式系统面临的配置问题

 微服务意味着要将单体应用中的业务拆分成一个个子服务，每个服务的粒度相对较小，因此系统中会出现大量的服务。由于每个服务都需要必要的配置信息才能运行，所以一套**集中式的、动态的配置管理设施**是必不可少的。

SpringCloud Config为微服务架构中的微服务提供**集中化的外部配置支持**，配置服务器为各个不同微服务应用的所有环境提供了一个中心化的外部配置。

SpringCloud Config分为**服务端和客户端**两部分。

**服务端也称为分布式配置中心**，它是一个独立的微服务应用，用来连接配置服务器并为客户端提供获取配置信息，加密/解密信息等访问接口

**客户端则是通过指定的配置中心来管理应用资源，以及与业务相关的配置内容，并在启动的时候从配置中心获取和加载配置信息配置服务器默认采用git来存储配置信息，**这样就有助于对环境配置进行版本管理，并且可以通过git客户端工具来方便的管理和访问配置内容。

- 集中管理配置文件
- 不同环境不同配置，动态化的配置更新，分环境部署比如dev/test/prod/beta/release
- 运行期间动态调整配置，不再需要在每个服务部署的机器上编写配置文件，服务会向配置中心统一拉取配置自己的信息
- 当配置发生变动时，服务不需要重启即可感知到配置的变化并应用新的配置
- 将配置信息以REST接口的形式暴露
- 由于SpringCloud Config默认使用Git来存储配置文件(也有其它方式,比如支持SVN和本地文件)，
  但最推荐的还是Git，而且使用的是http/https访问的形式

### 2.SpringCloud Config服务端配置

pom

```xml
<!-- springCloud Config -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

yml

```yaml
spring:
  application:
    name:  shop-config
  cloud:
    config:
      server:
        git:
          uri: https://github.com/zhuwt1996/springcloud-config.git
```

主启动类**@EnableConfigServer**

通过Config微服务是否可以从GitHub上获取配置内容

**配置读取规则**

/{application}-{profile}.yml

/{application}/{profile}[/{label}]

/{label}/{application}-{profile}.yml

### 3.SpringCloud Config客户端配置

pom

```xml
<!-- SpringCloud Config客户端 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

bootstrap.yml

applicaiton.yml是**用户级的资源配置项**
bootstrap.yml是**系统级的，优先级更加高**

Spring Cloud会创建一个**Bootstrap Context**，作为Spring应用的Application Context的**父上下文**。初始化的时候，Bootstrap Context负责从外部源加载配置属性并解析配置。这两个上下文共享一个从外部获取的Environment。Bootstrap属性有高优先级，默认情况下，它们**不会被本地配置覆盖**。 Bootstrap context和Application Context有着不同的约定，
所以新增了一个bootstrap.yml文件，保证Bootstrap Context和Application Context配置的分离。

```yaml
spring:
  cloud:
    config:
      name: shop-config-client #需要从github上读取的资源名称，注意没有yml后缀名
      profile: dev   #本次访问的配置项
      label: master
      uri: http://config-3344.com:3344  #本微服务启动后先去找3344号服务，通过SpringCloudConfig获取GitHub的服务地址
```

bootstrap.yml里面的profile值是什么，决定从github上读取什么

