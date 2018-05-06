# spring-cloud-prototype

1. Build all the projects
2. Start soschat-discovery (Eureka) server 
3. Start soschat-gateway (Zuul) server
4. Start config server - soschat-config-server
5. Start soschat-web (this will require additional configuration of apache geode in local)
  a. install apache-geode
  b. go to terminal and create a directory (e.g. geode-server) - enter gfsh (this will open gfish console)
  c. execute following command in gfsh: 
    c.1 start locator --name=LocatorOne
    c.2 start server --name=ServerOne
6. Start soschat-web-redis (this will require redis server running in local)

Eureka should start in http://localhost:8761 - it should show two microservices running (soschat-web and soschat-web-redis)

soschat-web is running in 8081 and soschat-web-redis in 8082 and following API's will work:
http://localhost:8081/hello
http://localhost:8082/hello

Both can be accessed from Zuul server using single port and depending on routing configuration in zuul

`zuul.routes.soschat-web.path=/web/v1/** `

`zuul.routes.soschat-web.url=http://localhost:8081`

`zuul.routes.soschat-web-redis.path=/web-redis/v1/**`

`zuul.routes.soschat-web-redis.url=http://localhost:8082`

soschat-web - http://localhost:8765/web/v1/hello
soschat-web-redis - http://localhost:8765/web-redis/v1/hello

## Spring config server
Output of API: http://localhost:8765/web/v1/hello is fetching message from property file configured in config-server (http://localhost:8888/soschatweb/message)
- Property can be updated in git repo https://github.com/rhishirajnema/config/blob/master/soschatweb.properties
- Execute refresh API: http://localhost:8081/actuator/refresh - POST
- Changed will reflect here : http://localhost:8765/web/v1/hello without restarting JVM

###### Encryption/Descryption
1. Encrypted password is stored in github repo - https://github.com/rhishirajnema/config/blob/master/soschatweb.properties
2. This API returns descrypted password - http://localhost:8081/password
3. Encryption API in config server - http://localhost:8888/encrypt - POST (send text to be encrypted in body)
