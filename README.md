#Spring Cloud Config Server Demo

Add the following dependencies to your application to enable spring cloud config

```
<dependency>
		<groupId>io.pivotal.spring.cloud</groupId>
		<artifactId>spring-cloud-services-starter-config-client</artifactId>
</dependency>
```

Add Dependency management to pull in latest spring cloud versions

```
<dependencyManagement>
	<dependencies>
		  <dependency>
				<groupId>io.pivotal.spring.cloud</groupId>
				<artifactId>spring-cloud-services-dependencies</artifactId>
				<version>1.1.0.RC1</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>Brixton.SR1</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
	</dependencies>
</dependencyManagement>
```

To run locally run the config-server project to startup a local config server.  Otherwise it will just pull values from application instead of remote GIT repo.

To deploy to cloud Foundry

Push menu application with --no-start
```
cf push --no-start
```
Create a config-service

```
cf create-service -c '{ "git": { "uri": "https://github.com/calebwashburn/spring-cloud-demo-config", "label": "master" } }' p-config-server standard config-server
```

Bind the application to the service

```
cf bind-service menu config-server
```

Start up the application which will finish staging and bind with the variables from config server

```
cf start menu
```

Anytime configuration is changed in GIT do either of the following.

```
cf restart
```

or can dynamically force a refresh but only refreshes a single node.  See Spring bus support for enabling cluster wide refresh

```
curl -X POST https://menu.apps.caleb-washburn.com/refresh
```
