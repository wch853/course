FROM openjdk:8-jre-slim
LABEL maintainer="wch wch@163.com"

COPY target/course-dubbo-server-1.0-SNAPSHOT.jar /course-dubbo-server.jar

ENTRYPOINT ["java", "-jar", "/course-dubbo-server.jar"]