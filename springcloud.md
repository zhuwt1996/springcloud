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

1. 是什么

   Netflix的一个核心模块。Eureka是一个基于REST的服务，用于定位服务，以实现云端中间层服务发现和故障转移。有了服务发现与注册，只需要使用服务的标识符就可以访问到服务，而不需要修改服务调用的配置文件了。

2. 原理

3. ​





## 五、ribbon

## 六、feign

## 七、hystrix

## 八、zuul

## 九、config

## 十、相关面试题