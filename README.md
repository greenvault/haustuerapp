# Haustuer-App-Server

[![Build Status](https://travis-ci.org/greenvault/haustuerapp-server.svg?branch=master)](https://travis-ci.org/greenvault/haustuerapp-server)

## Development

- Start postgres at port 5432

  ```
  $ docker-compose up db
  ```

- Start backend at port 8080

  ```
  $ cd server
  $ mvn clean package
  $ java -jar target/haustuerapp-services-*.jar --spring-profiles-active=dev
  ```

## Documentation

- /api/docs ([local](http://localhost:8080/api/docs/index.html), [test](https://haustuerapp.herokuapp.com/api/docs/index.html)) - hand crafted API doc with spring-rest-docs (WIP)
- /api/swagger/index.html ([local](http://localhost:8080/api/swagger/index.html), [test](https://haustuerapp.herokuapp.com/api/swagger/index.html)) - generated swagger API doc

## Stages

- test: https://haustuerapp.herokuapp.com/

## CI

Auto deployment from GitHub (`wip` branch) to https://haustuerapp.herokuapp.com
