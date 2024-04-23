# Task Management System

This application is a task management system that allows users to create, delete, update, and sort tasks.

## Data Model
- ID
- Task Title
- Task Description
- Task Creation Date
- Deadline
- Task Status (new, in progress, completed)

## Functionality
- Task Creation
- Task Deletion
- Task Update
- Task Sorting

## Error Handling
- Global exception handler `@ControllerAdvice` to handle possible application errors.

## Frontend
- Usage of Thymeleaf with Spring MVC for server-side rendering.

## Testing
- Writing unit and integration tests for the application using JUnit and Mockito.

### Unit Testing

We have created unit tests for the classes and methods of our application using the JUnit framework. You can review our tests in the file [TaskServiceUnitTest.java](to-do-list/src/main/java/com/example/todolist/Service/TaskServiceUnitTest).

### Integration Testing

To verify the interaction of various components of our application and their proper functioning together, we conduct integration testing. We use the Mockito framework to create mocks and emulate the behavior of dependent components.

## Usage of PostgreSQL Database

This application requires a PostgreSQL database.

### Installation and Configuration of PostgreSQL

1. **Install PostgreSQL on your computer by following the instructions on the [official PostgreSQL website](https://www.postgresql.org/download/).**

2. **After installation, specify the relevant data for connecting to the PostgreSQL database (host, port, database name, username, and password) in the configuration file of your project (`application.properties`).**

3. **After running the application in your integrated development environment (IDE), the `Task.java` class will automatically create the necessary tables in the database. Just ensure that your database connection configuration is correct.**

Please let me know if you need anything else!

[JP](README_JP.MD) | [DE](README_DE.MD)