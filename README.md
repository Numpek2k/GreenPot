<p align="center"><img width="35%" src="https://github.com/Numpek2k/EngineeringThesis/blob/master/Media/logo.png"></p>

GreenPot is a project developed to fulfill the requirements of an engineering thesis. 
The aim of the thesis was to create a web application based on a client-server architecture,
which will meet the needs of gardeners seeking information about plants.

### Tech stack:

#### Backend:
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

#### Frontend:
![TypeScript](https://img.shields.io/badge/TypeScript-007ACC?style=for-the-badge&logo=typescript&logoColor=white)
![Angular](https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)
![HTML](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)

#### Database:
![AWS](https://img.shields.io/badge/Amazon_AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white)
![Postgres](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

#### Testing:
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

<details>
  <summary>Database:</summary>

### PostgreSQL and AWS

For the purposes of the project, the database was implemented in PostgreSQL. AWS was utilized for hosting the database itself.
The database connection is located in the file [application.properties](GreenPotBack/src/main/resources/application.properties),
and it appears as follows:
```
server.port=${port}
spring.datasource.url =${db.url}
spring.datasource.username =${db.username}
spring.datasource.password =${db.password}
.
.
.
```

</details>

<details>
  <summary>WebSocket:</summary>

### User chat based on WebSockets

Websocket is used to implement real-time, low latency communication between users (chat).
Web sockets reduced server load, efficient resource usage, and support for bidirectional communication and event handling. 
They provide a seamless and interactive chat experience while ensuring cross-platform compatibility and security.

</details>

## Backend of  application:
