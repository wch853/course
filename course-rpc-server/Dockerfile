FROM openjdk:8-jre-slim
MAINTAINER wch wch@163.com

COPY target/course-rpc-server-1.0-SNAPSHOT.jar /course-rpc-server.jar

ENTRYPOINT ["java", "-jar", "/course-rpc-server.jar"]