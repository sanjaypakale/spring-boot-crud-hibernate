# spring-boot-crud-hibernate

This is the rest api application which demonstrates the CRUD operations by using spring boot hibernate and mysql. 

How to run this application?

1. clone the application in the local drive and open project in your fevorite IDE. I have used Intellij for development.
2. Create an database and table by using below mysql script.

CREATE DATABASE crudapi;
use crudapi;

CREATE TABLE tbl_employee
(
id int NOT NULL primary key auto_increment,
name varchar(250),
gender varchar(255),
department varchar(255),
dob date
)

INSERT INTO `crudapi`.`tbl_employee`
(
`name`,
`gender`,
`department`,
`dob`)
VALUES
('sanjay','male','IT','1985-07-30');

3. Install the maven dependencies and run the api.
4. Use postman for testing api.



