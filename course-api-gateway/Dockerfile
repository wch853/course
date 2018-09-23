FROM openjdk:8-jre-slim
LABEL maintainer="wch wch@163.com"

COPY target/course-api-gateway-1.0-SNAPSHOT.jar /course-api-gateway.jar

ENTRYPOINT ["java", "-jar", "/course-api-gateway.jar"]
