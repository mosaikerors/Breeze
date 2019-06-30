# Breeze

## Repo introduction

In this repo is the course project of Internet Platform, 2019 Spring semester. 

Its objective is to practice Cloud Native.

### Technology stack

#### Front-end

+ react @16.8.6
+ material-ui @4.1.1

#### Back-end

+ Spring Boot @2.1.4.RELEASE
+ Spring Cloud @Greenwich.SR1

#### Database

+ MySQL @8.0.16
+ MongoDB @4.0.9

### Coding standards

See [here](./Java-Style-Guide.md)

### Microservices

| service name   | port  |
| -------------- | ----- |
| eureka-server  | 61455 |
| user-service   | 6140  |
| hean-service   | 6150  |
| admin-service  | 6160  |
| auth-service   | 6170  |
| feign-consumer | 6180  |

### Branches

+ **master**: main branch (there may be some problems in front-end directory)
+ **mydev**: development branch
+ **fake:** branch for final presentation, many buggy codes are deleted.

## Something trivial

This is the first time for mosaikerors to work together, during which there were both happiness and trouble. From the project, we learned and practiced some skills, like Spring Cloud, Tests, Drone and the most important, teamwork. But we also encountered many troubles and even now, some of them are still open, such as how to make a feign interact with a service in deployed state and how to test gracefully.

Well, as not just a course project, but preparation for *Winsper*, we can say *Breeze* is a little success.

And finally, if you would like to grant some help or get confused or curious about *Breeze*, welcome to raise an issue~ 

##### Last-modified date: 2019.6.28, 4 p.m.

