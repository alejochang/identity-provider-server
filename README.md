# Identity Provider Server

Spring Boot Server

## Overview
This server was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.
By using the [OpenAPI-Spec](https://github.com/swagger-api/swagger-core), you can easily generate a server stub.
This is an example of building a swagger-enabled server in Java using the SpringBoot framework.

The underlying library integrating swagger to SpringBoot is [springfox](https://github.com/springfox/springfox)

Start your server as an simple java application

You can view the api documentation in swagger-ui by pointing to
http://localhost:8899/

Change default port value in application.properties


##Files added/modified

com.alejochang.controller.CredentialsController

com.alejochang.filter.CORSFilter

com.alejochang.model.AuthToken

com.alejochang.model.User

com.alejochang.repository.AuthTokenRepository

com.alejochang.repository.UserRepository

com.alejochang.service.UserService

com.alejochang.service.UserServiceImpl

com.alejochang.IdentityProviderServerBoot


#Database
PostgreSQL 9.5