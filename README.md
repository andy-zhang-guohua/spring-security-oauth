## Spring Security OAuth

### Relevant Articles: 
- [Spring REST API + OAuth2 + AngularJS](http://www.baeldung.com/rest-api-spring-oauth2-angularjs)
- [OAuth2 for a Spring REST API – Handle the Refresh Token in AngularJS](http://www.baeldung.com/spring-security-oauth2-refresh-token-angular-js)
- [Spring Security OAuth2 – Simple Token Revocation](http://www.baeldung.com/spring-security-oauth-revoke-tokens)
- [OAuth2.0 and Dynamic Client Registration](http://www.baeldung.com/spring-security-oauth-dynamic-client-registration)
- [Testing an OAuth Secured API with the Spring MVC Test Support](http://www.baeldung.com/oauth-api-testing-with-spring-mvc)
- [Logout in a OAuth Secured Application](http://www.baeldung.com/logout-spring-security-oauth)
- [OAuth2 Remember Me with Refresh Token](http://www.baeldung.com/spring-security-oauth2-remember-me)
- [Angular 4 Upgrade for Spring Security OAuth](http://www.baeldung.com/angular-4-upgrade-for-spring-security-oauth)


### Build the Project
```
mvn clean install
```

### Notes
- This project consists of 4 main sub-modules, each sub-module is a Spring Boot Application running on specific port
    - spring-security-oauth-server       (port = 8081)
    - spring-security-oauth-resource     (port = 8082)
    - spring-security-oauth-ui-implicit  (port = 8083)
    - spring-security-oauth-ui-password  (port = 8084)
- To run the project, run both _spring-security-oauth-server_ and _spring-security-oauth-resource_ first - then run any of the UI modules

- You can run any sub-module using command line: 
```
mvn spring-boot:run
```



### 功能点备注

#### 演示主目标功能点    
    1. Oauth Server 访问 token store 采用 JDBC MySQL 模式
    2. Oauth Server 用户信息保持 In Memory 模式 (不是JDBC模式)
    3. Resource service 访问 token store 采用 JDBC MySQL 直接访问模式 (不是基于URL的远程访问模式)
    4. 密码模式　resource owner password credentials , OAuth2 Password flow 
        spring-security-oauth-ui-password 访问受保护页面时总是跳转到登录页面要求用户登录 
        Start with the two simple pages – “index” and “login”; once a user provides their credentials, 
        the front-end JS client uses them to acquire an Access Token from Authorization Server.
    5. 简化模式 implicit
        spring-security-oauth-ui-implicit
        Using AngularJS directive OAuth-ng which can connect to OAuth2 server with implicit grant flow
#### 其它功能点
    1. Spring boot + AngularJS + bootstrap
    2. Java 1.8
    3. UTF-8
    4. JPA
