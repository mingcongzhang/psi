# Venue Ticketing

As a coding exercise, this simple API helps customers find, hold and reserve venue seats. It is frameworked by Spring Boot 2.

Assumptions:
1. Total number of seats is 100; there are 10 rows each of which has 10 seats
2. The best seat location is in front
3. The best group seats are adjacent
4. Timeout for held seats is 10 seconds

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

```
JDK 1.8 or later
Gradle 4+
Preferably IntelliJ IDEA
```

### Installing

Clone the code

```
git clone git@github.com:mingcongzhang/ticketing.git
```

## Run

Build project
```$xslt
gradle build
```
Run application
```$xslt
gradle bootRun
```

## API documentation

A complete API documentation is in Swagger UI

```
http://localhost:8080/swagger-ui.html#/
```

### Methods
``POST /findAndHoldSeats``<br /> 
``POST /reserveSeats``<br /> 
``PUT /reset``<br /> 
``GET /numSeatsAvailable``<br /> 
``GET /test``<br /> 

## Built With

* [Gradle](https://gradle.org/) - Dependency Management
* [Spring](https://spring.io/) - Used to generate Spring Boot Framework

## Authors

* **Alan Zhang**

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Thanks to Spring.io starter project
