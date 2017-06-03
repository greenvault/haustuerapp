# Haustuer-App

## Development

Start postgres at port 5432

```
$ docker-compose up
```

Start backend at port 8080
```
$ cd server
$ mvn clean package
$ java -jar target/haustuerapp-services-*.jar --spring-profiles-active=dev
```

