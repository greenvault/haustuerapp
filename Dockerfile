FROM maven:3.5-jdk-8

WORKDIR /src/haustuerapp_server

COPY . .

RUN mvn clean package
RUN mkdir -p /opt/haustuerapp_server && \
  cp target/haustuerapp-server-*.jar /opt/haustuerapp_server

CMD exec java -jar /opt/haustuerapp_server/haustuerapp-server-*.jar

