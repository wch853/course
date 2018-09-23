mvn clean package -DskipTests=true && docker build -t course-api-gateway:1.0 .

REM docker run -it course-api-gateway:1.0 --spring.profiles.active=prd --server.port=80 --course.web.host=course-web --course.web.port=8080