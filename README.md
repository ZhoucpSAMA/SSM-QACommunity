# 			基于SSM的前后端分离在线考核系统

##  简介

在线考核系统（Problem System）采用主流Java EE 轻量级框架整合开发。

大二上所做，技术有限，很多问题需要完善。欢迎学习交流。


##  获取源码

https://gitee.com/zcpsama/problem-system

##  项目结构

> 目录结构 
>
> - controller 控制层
> - service 服务层
> - pojo 实体对象
> - dao 数据库操作层
> - config 配置
> - utils 工具类
> - web 前端视图
> - resource 静态资源
>
> 数据库表结构
>
> - user
> - problem
> - answer
> - comment 

##  环境工具及技术栈

> ​     后端

- JDK1.8

- Mysql5.7 数据库

- Spring5 容器

- SpringMVC 

- Mybatis ORM持久层框架

- PageHelper 分页插件

- Druid 数据连接池

- jackson/fastjson JSON处理

- lombok 简化代码

- maven 项目构建

  > 前端

- HTML/CSS/JS

- Vue/elementUI

- jQuery/ajax 

  ## 使用说明

  - 用idea打开项目等待maven导包完成
  - 在pom.xml中将mysql-connector-java的版本改成与本机对应版本
  - 修改resouces里jdbc.properties中数据（mysql8.0要jdbc连接要加时区否则报错）
  - 新建problemsys数据库导入sql脚本数据
  - 项目结构中打包添加lib目录依赖
  - 然后用tomcat9跑起来！