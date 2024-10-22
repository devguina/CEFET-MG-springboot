# CEFET/MG - Spring Boot API
## Description:
Hello, this project concerns the subject of Web Application Development - Rodrigo De Lima, Professor CEFET-MG and Software specialist.
This repository will evolve according to the classes.
At moment:
- Docker - compose file
- Database - Postgres 
- Migrations - Flyway
- Spring Boot version 3.3.4
- Maven Dependencies:
- - Spring JPA
- - Spring Web
- - Lombok
- - Spring Dev Tools

### Technologies
![](https://skillicons.dev/icons?i=aws,vue,java,spring,docker,postgres,&perline=6)

#### Start the Project
Follow the steps below to run the application correctly: 
- To start the project, start the docker compose file, change port and credentials if necessary.
- If you changed something in the container, correct it in the code, in "application.yaml".
- Load the "pom.xml" file.
- Run the application.

#### Entities 

#### Ending-points
- base: /CEFET
- UserController = /user
- - GET = /{id}
- - GET ALL = /
- - POST = /{id}
- - PUT = /{id}
- - DELETE = /{id}

        {
        "name" : "exampleName",
        "login" : "exampeLogin",
        "password" : "examplePassword"
        }
example request: localhost:${port}/CEFET/user/{id}

---------------------
- StateController = /state
- - GET = /{id}
- - GET ALL = /
- - POST = /
- - PUT = /{id}
- - DELETE = /{id}

example request: localhost:${port}/CEFET/state/{id}

----
    {
    "nanme" : "Example",
    "abbreviation" : "ex-ample"
    }
    

-