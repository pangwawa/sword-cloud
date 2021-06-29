# sword-cloud
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

Spring Cloud Alibaba （Dubbo RPC + SpringCloud HTTP RPC结合）

Dubbo 

Nacos

Sentinel

Seata

Spring Cloud Sleuth （zipkin）

Spring Cloud Stream （ RocketMQT ）

Spring Cloud Security

Spring Cloud Gateway

Spring Cloud OpenFeign

MySQL

ElasticSearch

Redis

MinIO

GitLab + Jenkins + Docker + Kubernetes

Prometheus + Gafana

## 
Sword is a integrate project  for developers to quickly build Spring Cloud Solution



自定义 @ApiLog 日志
自定义 @ApiAuth 权限校验

binlog 同步elasticsearch

seata

## 权限方案
1、用户权限： 网关控制
2、微服务间权限： A方案：通过微服务专用方式认证，使用特定标识、token进行快速认证； B方案： 服务全部署在特定网络，只有网关是允许外网访问，其他都只能通过内外进行访问。

0629： oauth gateway 、 seata、日志与链路
