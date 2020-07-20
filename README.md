# Perfect Score

## Introduction
Perfect Score is a Spring Boot Application that performs predictions for English Premier League football games. It also provides a front-end aspect so that results and predictions can be checked.

## Project Structure

| Module | Description |
| ------------- | ------------------------------------------------------------------ |
| perfect-app | Module containing the core application and controllers. |
| perfect-domain | Module containing the persistence tier repositories and entities. |
| perfect-service | Module containing services to access the persistence tier and also result prediction services. |

## Lombok
The project uses Project Lombok for automating the generation of getters/setters, as well as other methods such as "equals", "hashCode" and "toString".
Lombok is a Maven dependency which runs during compile-time to generate these methods. Plugins for IDE's (i.e. Eclipse/IntelliJ), must be installed to avoid syntax errors within the IDE.

## Dependency Management
Dependencies are defined in the parent pom file and in the module (child) pom files. The parent pom file contains both the dependencies for all modules and the required dependency versions. Changing the version numbers in the (central) parent pom file will affect all modules.

## Testing
Various unit tests are included.

## Building
To build the application JAR file, run the Maven build process against the parent pom file (e.g. mvn clean install). This will gather all the required dependencies and generate an application JAR file in the **perfect-app\target** directory.

## Running
To run the software, run the application directly using the Java command line as below:

```
java -jar perfect.jar
```

## Public Access
Some aspects of the repository source code have been obscured/removed to protect intellectual property calculations or where development is work-in-progress.

## Deployment
The public version of Perfect Score is deployed at:

[https://perfect-score.co.uk](https://perfect-score.co.uk)
