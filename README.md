# SpringBoot-package

***
顺手给孩子点个求星星吧
***

## 1. 基础开发框架

### 1-1. 用到的技术

- 1-1-1. springboot 3
- 1-1-2. java 17
- 1-1-3. pageHelper 1.4.6
- 1-1-4. mybatis 3.0.0
- 1-1-5. lombok
- 1-1-6. mysql
- 1-1-7. jwt 4.4.0
- 1-1-8. aliyun.oss 3.15.1
- 1-1-9. redis
- 1-1-10. swagger 1.5.21
- 1-1-11. xiaoymin 2.0.8
- 1-1-12. commons-lang3

### 1-2. 项目结构

* 1-2-1. org.lucky.kfirstsnowluckyadmin
    1. config \*\* 跨域配置文件 \*\*
    2. controller \*\* 业务层 \*\*
    3. exception \*\* 异常处理 \*\*
    4. interceptor \*\* 拦截器 \*\*
    5. mapper \*\* 数据库接口 \*\*
    6. model \*\* 实体类 \*\*
    7. service \*\* 实现类接口 \*\*
    8. service.impl \*\* 实现类 \*\*
    9. utils \*\* 工具包 \*\*
    10. KFirstSnowLuckyAdminApplication \*\* 启动文件 \*\*

### 1-3. 项目功能

* 1-3-1. 实现分页封装
* 1-3-2. 实现跨域
* 1-3-3. 实现JWT
* 1-3-4. 实现OSS
* 1-3-5. 实现Redis
* 1-3-6. 实现拦截器
* 1-3-7. 实现日志
* 1-3-8. 实现解析token并开启新线程存储用户简单信息
* 1-3-9. 实现md5加密
* 1-3-10. 实现全局异常处理，自定义异常类
* 1-3-11. 实现开发环境和生产环境配置

### 1-4. 项目启动

* 1-4-1. 修改application-dev.yml配置文件

``` yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/自己的数据库?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: 账号
    password: 密码
```

* 1-4-2. 修改application-prod.yml配置文件

``` yml
spring:
  datasource:
    url: jdbc:mysql://服务器地址:3306/自己的数据库?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: 账号
    password: 密码
```

* 1-4-3. 参考代码文件

``` java
controller 下的 TestController.java
参考（也可以自己删除）：model，service，service.impl，resource.mapper 的 book
```

* 1-4-4. oss utils.AliyunOSSUtils.java

```java
    private static final String ENDPOINT = "你的地址";

private static final String ACCESS_KEY_ID = "你的密钥";

private static final String ACCESS_KEY_SECRET = "你的密码";

private static final String BUCKET_NAME = "你的桶";
```
