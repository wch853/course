FROM openjdk:8-jre-slim
LABEL maintainer="wch wch@163.com"

COPY target/course-web-1.0-SNAPSHOT.jar /course-web.jar

ENTRYPOINT ["java", "-jar", "/course-web.jar"]