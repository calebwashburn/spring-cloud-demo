# Spring Cloud Service Registry

## Menu service
Follow the the directions in the Spring Cloud Config example and add the following....

Add the following dependencies to menu application to enable spring cloud service registry

```
<dependency>
  <groupId>io.pivotal.spring.cloud</groupId>
  <artifactId>spring-cloud-services-starter-service-registry</artifactId>
</dependency>
```


To run locally run the eureka-server project to startup a local eureka server on port 8761.  

To deploy to cloud Foundry

Push menu application with --no-start
```
cf push --no-start
```
Create service registry service

```
cf create-service p-service-registry standard service-registry
```

Bind the application to the service

```
cf bind-service menu service-registry
```

Start up the application which will finish staging and register with service registry

```
cf start menu
```

To get the url of the dashboard execute the following command and will need to login with your PCF credentials (same as cf cli)

```
cf service service-registry
```

By default the registry will use the route method for registration to change this to direct add the following to application.properties file.

```
spring.cloud.services.registrationMethod=direct
```

## Restaurant Service
The restaurant service consumes menu service via Netflix Ribbon client side load-balancer since menu used direct registration.  This allows balancing workloads across all the containers dynamically that menu service is registred on.  This is accomplished with the @LoadBalanced annotation.

```
@Autowired
@LoadBalanced
private RestTemplate rest;

public RestaurantMenu getMenu() {
		//if downstream service uses direct use http vs using https if route registration method for url
		
		URI uri = UriComponentsBuilder.fromUriString("http://menu/special").build().toUri();
		LOGGER.info(String.format("Invoking service on url: %s", uri.toString()));
		MenuSpecial menu = rest.getForObject(uri, MenuSpecial.class);
		return new RestaurantMenu(menu.getSpecial(), name);
}

```

Push the restaurant microservice

```
cf push restaurant
```

No need to bind or create the service as it already exists and manifest has the service listed as a dependency.



