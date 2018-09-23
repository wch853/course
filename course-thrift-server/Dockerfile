FROM openjdk:8-jre-slim
LABEL maintainer="wch wch@163.com"

COPY target/course-thrift-server-1.0-SNAPSHOT.jar /course-thrift-server.jar

ENTRYPOINT ["java", "-jar", "/course-thrift-server.jar"]