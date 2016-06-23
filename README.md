#Spring Cloud Config Server Demo with Spring Cloud Bus

Follow the setup for Spring Cloud Config Example and add the following dependency.

```
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>
```


To deploy to cloud Foundry must add a AMQP service to be the communication backbone between instances

Push menu application with --no-start
```
cf push --no-start
```
Create a rabbitMQ service

```
cf create-service p-rabbitmq standard menu-spring-bus
```

Bind the application to the service

```
cf bind-service menu menu-spring-bus
```

Start up the application which will finish staging and bind with rabbitMQ to create a application bus

```
cf start menu
```

Anytime configuration is changed in GIT can then be picked up by doing a post to bus/refresh which will notify all members of cluster to refresh their application context.

```
curl -X POST https://menu.apps.caleb-washburn.com/bus/refresh
```
