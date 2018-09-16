mvn clean package –DskipTests && docker build -t course-web:1.0 .

REM docker run -it course-web:1.0 --spring.profiles.active=prd --server.port=8080 --thrift.service.user.host=course-rpc-service --thrift.service.user.port=8081 --redis.host=192.168.1.106 --redis.port=6379 --registry.address=192.168.1.106:2181