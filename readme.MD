# SpringBoot 教程项目

本项目为 SpringBoot 综合示例，涵盖了常用的企业级开发集成方案。每个子模块独立演示一种技术或集成方式，适合学习和参考。

## 目录结构

- p01-hello：SpringBoot 入门示例
- p02-websocket：WebSocket 实时通信
- p03-kafka：Kafka 消息队列集成
- p04-i18n：国际化配置
- p05-filter-interceptor：过滤器与拦截器
- p06-schedule：定时任务
- p07-redirect：重定向处理
- p08-aop：AOP 面向切面编程
- p09-jwt：JWT 鉴权
- p10-netty：Netty 网络通信
- p11-docker：Docker 容器化
- p12-poi：POI Excel 导入导出
- p13-email：邮件发送
- p14-quartz：Quartz 定时任务
- p15-dom：DOM 操作
- p16-mapstruct：MapStruct 对象映射
- p17-xxl-job：XXL-Job 分布式任务调度
- p18-drools：Drools 规则引擎
- p19-mybatis：MyBatis 持久层
- p20-mybatis-generator：MyBatis 代码生成
- p21-swagger：Swagger3.0 接口文档
- p22-flyway：Flyway 数据库迁移
- p23-hutool：Hutool 工具类

## 环境要求

- JDK 1.8 及以上
- Maven 3.5 及以上
- MySQL 5.7/8.0（部分模块需要）

## 快速开始

1. 克隆项目：
   ```shell
   git clone https://github.com/yourname/springboot-tutorial.git
   cd springboot-tutorial
   ```
2. 进入对应模块，修改 `application.yml` 配置数据库等信息。
3. 编译并运行：
   ```shell
   mvn clean package
   java -jar p01-hello/target/*.jar
   ```
4. 访问对应服务端口。

## 常见集成说明

+ xxl 定义任务
```shell
# 官方文档 
https://www.xuxueli.com/xxl-job/

# 下载 xxl-job-admin
https://github.com/xuxueli/xxl-job

# 初始化数据库，启动admin项目，通过web访问
http://localhost:8080/xxl-job-admin

# 账号密码
admin/123456
```

+ drools 规则引擎
```shell
https://houbb.github.io/2020/05/26/rule-engine-01-drools
```

+ swagger3.0
```shell
# 启动服务访问地址
http://localhost:8080/swagger-ui.html

# swagger3.0 使用文档
https://juejin.cn/post/7128303076934418446
```

+ flyway 配置
```shell
flyway.baseline-description对执行迁移时基准版本的描述.
flyway.baseline-on-migrate当迁移时发现目标schema非空，而且带有没有元数据的表时，是否自动执行基准迁移，默认false.
flyway.baseline-version开始执行基准迁移时对现有的schema的版本打标签，默认值为1.
flyway.check-location检查迁移脚本的位置是否存在，默认false.
flyway.clean-on-validation-error当发现校验错误时是否自动调用clean，默认false.
flyway.enabled是否开启flywary，默认true.
flyway.encoding设置迁移时的编码，默认UTF-8.
flyway.ignore-failed-future-migration当读取元数据表时是否忽略错误的迁移，默认false.
flyway.init-sqls当初始化好连接时要执行的SQL.
flyway.locations迁移脚本的位置，默认db/migration.
flyway.out-of-order是否允许无序的迁移，默认false.
flyway.password目标数据库的密码.
flyway.placeholder-prefix设置每个placeholder的前缀，默认${.
flyway.placeholder-replacementplaceholders是否要被替换，默认true.
flyway.placeholder-suffix设置每个placeholder的后缀，默认}.
flyway.placeholders.[placeholder name]设置placeholder的value
flyway.schemas设定需要flywary迁移的schema，大小写敏感，默认为连接默认的schema.
flyway.sql-migration-prefix迁移文件的前缀，默认为V.
flyway.sql-migration-separator迁移脚本的文件名分隔符，默认__
flyway.sql-migration-suffix迁移脚本的后缀，默认为.sql
flyway.tableflyway使用的元数据表名，默认为schema_version
flyway.target迁移时使用的目标版本，默认为latest version
flyway.url迁移时使用的JDBC URL，如果没有指定的话，将使用配置的主数据源
flyway.user迁移数据库的用户名
flyway.validate-on-migrate迁移时是否校验，默认为true
```
+ mybatis 报错  
![图标](https://github.com/byebai95/springboot-tutorial/blob/master/image/mybatis_error.png)  
```yml
# 报错原因为 locations配置错误
# 错误配置
mybatis:
  mapper-locations: /mapper

# 正确配置  
mybatis:
  mapper-locations: /mapper/*.xml
``` 


+ 工具类 hutool
```shell
文档 https://gitee.com/dromara/hutool

<dependency>
    <groupId>cn.hutool</groupId>
    <artifactId>hutool-all</artifactId>
    <version>5.8.20</version>
</dependency>
```