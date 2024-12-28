# Incident Management System README

1. External Libraries

|Library|Version|Purpose|
|--|--|--|
|H2|2.3.232|use to store incident data|
|junit-jupiter-api|5.11.4|for unit test|

2. Database Schema

```sql
   create table incident(
    id bigint primary key COMMENT "incident id",
    type char(2) COMMENT "type of incident",
    title varchar(32) COMMENT "title of incident",
    description varchar(1024) COMMENT "description of incident",
    create_user varchar(16) COMMENT "create user",
    create_datetime date COMMENT "create datetime",
    update_user varchar(16) COMMENT "update user",
    update_datetime date COMMENT "update datetime"
  ) COMMENT "incident table";
```

3. Unit test

    The unit test is implemented by JUnit5.
    The main unit test class is IncidentControllerTest.java.

    When running the test case, you should run from the main class of IncidentControllerTest, beacuse the bigger ordered test is dependent on the smaller ordered test. Such as the test case of updateIncident() is dependent on the test case of createIncident().

4. Architecture

   This project is a simple web application, which is implemented by Spring Boot.
   The architecture is as follows:

    controller -> service -> repository -> database

    Data flow:
    * Controller provides the RESTful API.
    * Client or frontend can call the apis to send or receive VO object to manage incident data.
    * Controller pass the vo object to service layer.
    * Service layer transfor the vo object to entity object and pass to repository layer and return the entity object.
    * Repository layer save the entity object to database or get the data from database to return the entity object.
    * The database is H2 as a in-memory database.

    Exception handling:
    * Defined BusinessException for business exception. Such as when update or delete the incident but id is not exist.
    * Defined GlobalExceptionHandler for global exception handling.
    * Defind BusinessError for business error code and message.

    Database configuration:
    * Use auditorware to set the create user, create datetime, update user and update datetime.