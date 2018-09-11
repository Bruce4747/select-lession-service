# 选课系统

业余时间完成的文档型项目，目前程序的入口在`user-manager-controller`模块，
通过`zuul`模块路由到具体服务模块。抽取了`user-service-api`作为公共模块

技术选型：
---
- Spring boot
- Spring Cloud
- Spring zuul
- Spring Hystrix

包含模块
---
- `user-manager-controller` 对提供控制层服务
- `user-service` 用户注册，登陆服务实现
- `user-service-api` 抽取公共模块及接口，抽取的不理想
- `zuul-service` 目前只提供路由功能，后期会做降级等

个人博客[地址](http://radiancel.github.io)

会经常分享一些好玩的技术，一起读底层实现
联系我：931305033