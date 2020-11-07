# IMProject
#### 简介

本项目为即时通讯APP的后台程序,项目整体由SSM框架搭建，为前端提供了用户登录注册、头像上传、词云生成、文字信息与图片消息发送、历史消息查询、添加好友等接口，且自带信息情感分析、屏蔽词处理功能。具体接口与功能可以在项目的[API文档](API.md)中查看。



#### 项目架构

项目整体架构是由Spring + SpringMVC + MyBatis搭建的，使用Controller->Service->Dao的分层架构，并在其外部使用全局ExceptionHandler用于统一处理项目中可能出现的异常情况。在Controller层采用SpringMVC提供的请求拦截与转发功能实现一种Controller处理一类事件，在Service层通过先抽象再实现的方式完成了对各项功能的处理，Dao层则只留接口利用MyBatis的动态代理与mapper文件实现具体数据库操作。



#### 项目开发环境

后端：IntelliJ IDEA 2020.2.1、JDK8、Tomcat9.0.30、mysql5.7.31、win10 64 位。



#### 注意事项

项目不含网络通信功能，需要配合外部SDK(如TIMSDK)共同使用(具体可参照该项目对应的前端[IMProjectClient](https://github.com/YeHIT/IMProjectClient))。

