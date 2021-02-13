# embl-person-manage-rest-service

embl-person-manage-rest
- API version: 1.0
    - Build date: 2021-02-11T12:16:25.959+13:00[Pacific/Auckland]

EMBL API

## Requirements

Building the API client library requires:
1. Java8
2. Maven

## Installation

To install the API service library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```


### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>nz.co.vodafone.dxl.service</groupId>
    <artifactId>embl-person-manage-rest-service</artifactId>
    <version>1.0</version>
    <scope>compile</scope>
</dependency>
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/embl-person-manage-rest-service-1.0.jar`
* `target/lib/*.jar`

## Getting Started

There are various options to build or run the micro-service locally eg:

# build against sonarQube:
(cd embl-person-manage-rest-service; mvn clean verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.host.url=http://172.20.162.9:31900)

# run locally with test configuration
(cd embl-person-manage-rest-service; mvn clean verify spring-boot:run -Dspring.config.location=src/test/resources/application.yaml)


## Documentation for API Endpoints

All URIs are relative to *http://localhost*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*EmblPersonManageRestService* | [**createPerson**](docs/EmblPersonManageRestService.md#createPerson) | **POST** /api/v1/persons | create person
*EmblPersonManageRestService* | [**deletePerson**](docs/EmblPersonManageRestService.md#deletePerson) | **DELETE** /api/v1/persons/{personId} | delete person by personId
*EmblPersonManageRestService* | [**fetchAllPersons**](docs/EmblPersonManageRestService.md#fetchAllPersons) | **GET** /api/v1/persons | fetch all the persons
*EmblPersonManageRestService* | [**fetchPerson**](docs/EmblPersonManageRestService.md#fetchPerson) | **GET** /api/v1/persons/{personId} | fetch person by personId
*EmblPersonManageRestService* | [**updatePerson**](docs/EmblPersonManageRestService.md#updatePerson) | **PUT** /api/v1/persons/{personId} | update person by personId


## Documentation for Models

 - [Person](docs/Person.md)
 - [PersonDetails](docs/PersonDetails.md)
 - [Persons](docs/Persons.md)



## Author



