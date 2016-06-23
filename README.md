# spring-cloud-demo
Demo of Spring cloud services running on Pivotal Cloud Foundry

- Branch simple-boot-app starts with a simple spring boot application that exposes a single rest endpoint for a menu microservice.

- Branch spring-cloud-config enhances the initial example by adding spring-cloud support and pulling properties that were packaged in the application in the initial example from Spring Cloud Config server which was sourced by GIT repo

- Branch spring-cloud-config-spring-bus enhances the previous example to enable a cluster wide refresh to be trigger by leveraging Spring Bus and RabbitMQ.

- Branch spring-service-registry adds the capabilities of registering the menu service with Spring Cloud Service registry via the direct registration method and introduces a restaurant service that consumes the menu service via Ribbon and Service Registry

- Brand spring-circuit-breaker adds fallback capabilities to restaurant service when menu service is unavailable via Hystrix support


References

- http://docs.pivotal.io/spring-cloud-services/index.html
- http://projects.spring.io/spring-cloud/spring-cloud.html
