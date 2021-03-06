## Spring Security OAuth

### Relevant Articles: 
- [Spring REST API + OAuth2 + AngularJS](http://www.baeldung.com/rest-api-spring-oauth2-angularjs)
- [Using JWT with Spring Security OAuth](http://www.baeldung.com/spring-security-oauth-jwt)
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
基于 Anjular 的 SPA, 使用 AJAX 进行登录和退出，不是使用直接跳转到 login page 的方式。
