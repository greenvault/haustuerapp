FROM maven:3.5-jdk-8

WORKDIR /src/haustuerapp_services

COPY . .

RUN mvn clean package
RUN mkdir -p /opt/haustuerapp_service && \
  cp target/haustuerapp-services-*.jar /opt/haustuerapp_service

CMD exec java -jar /opt/haustuerapp_service/haustuerapp-services-*.jar

