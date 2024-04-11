

# sword-cloud

基于DDD(领域驱动设计)开发的脚手架， 能让项目一开始就符合领域驱动设计规范， 推动DDD在实际生产项目中的落地。

将常用的技术栈整合起来，包括 Dubbo RPC 、HTTP RPC协议，平台网关、Oauth2.0、搜索引擎、分布式事务、限流、熔断、降级、链路追踪，可用于快速开发SpringCloud 应用服务

``` lua
sword-cloud
├── sword-common -- 工具类及通用代码
├── sword-gateway -- 网关
├── sword-oauth -- 认证授权
├── sword-services -- 平台服务聚合
├── ----- sword-service-user -- 用户
├── sword-starters -- 平台自有starters聚合
└── sword-ops -- 运维管理模块（管理后台，数据可视化，平台监控）
```
## 端口

50000: sword-gateway

50001: sword-oauth

50002: sword-service-user

50003: sword-service-blog

50010: sword-ops

# 技术栈
技术栈

- [x] Spring Cloud Alibaba 

- [x] Dubbo 

- [x] Nacos

- [x] Sentinel

- [x] Seata

- [x] Spring Cloud Sleuth （zipkin）

- [x] Spring Cloud Stream （ RocketMQ ）

- [x] Spring Cloud Security

- [x] Spring Cloud Gateway

- [x] Spring Cloud OpenFeign

- [x] MySQL

- [x] ElasticSearch

- [x] Redis

- [x] MinIO

- [x] GitLab + Jenkins + Docker + Kubernetes

- [x] Prometheus + Gafana

- [x] Flowable

- [x] xxl-job

## 
Sword is a integrate project  for developers to quickly build Spring Cloud Solution



自定义 @ApiLog 日志
自定义 @ApiAuth 权限校验

binlog 同步elasticsearch

seata

## 权限方案

**1、用户权限： 网关控制**

用户获取token，并携带该token进行访问

网关获取并校验token是否有效

对DefaultSecurityFilterChain 进行修改，增删过滤器，或自定义SecurityFilterChain

**2、微服务间权限：**

A方案：通过微服务专用方式认证，使用特定标识、token进行快速认证； B方案： 服务全部署在特定网络，只有网关是允许外网访问，其他都只能通过内外进行访问。

外部用户通过网关访问，网关鉴权，基于OAuth，通过网关访问微服务，

微服务间，网关和微服务间，通过特定的鉴权规则校验


spring cloud gateway 不是使用 servlet容器，所以 不能通过servlet 的filter拦截权限校验， 需要自定FIlter 拦截 
