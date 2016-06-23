# Spring Cloud Circuit Breaker

## Menu service
Follow the the directions in the Spring Service Registry example and add the following to restaurant application


```
<dependency>
			<groupId>io.pivotal.spring.cloud</groupId>
			<artifactId>spring-cloud-services-starter-circuit-breaker</artifactId>
</dependency>
```

Annotate your application with @EnableCircuitBreaker

```
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

}
```


Annotate the method that you wish to circuit break on.

```
@HystrixCommand(fallbackMethod = "getDefaultMenu")
public RestaurantMenu getMenu() {
	//if downstream service uses direct use http vs using https if route registration method for url

	URI uri = UriComponentsBuilder.fromUriString("http://menu/special").build().toUri();
	LOGGER.info(String.format("Invoking service on url: %s", uri.toString()));
	MenuSpecial menu = rest.getForObject(uri, MenuSpecial.class);
	return new RestaurantMenu(menu.getSpecial(), name);
}

public RestaurantMenu getDefaultMenu() {
	return new RestaurantMenu("Sold out", name);
}

```

Update property in application.properties to tell Ribbon to check on new registrations quicker so when downstream service comes online it will be picked up as soon as possible.

```
producer.ribbon.ServerListRefreshInterval=5000
```


Push restaurant application with --no-start
```
cf push --no-start
```
Create circuit breaker dashboard service

```
cf create-service p-circuit-breaker-dashboard standard circuit-breaker
```

Bind the application to the service

```
cf bind-service restaurant circuit-breaker
```

Start up the application which will finish staging and register with circuit breaker dashboard

```
cf start restaurant
```

To get the url of the dashboard execute the following command and will need to login with your PCF credentials (same as cf cli)

```
cf service circuit-breaker
```
