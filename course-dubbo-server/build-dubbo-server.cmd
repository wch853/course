mvn clean package -DskipTests=true && docker build -t course-dubbo-server:1.0 .

REM docker run -it course-dubbo-server:1.0 --spring.profiles.active=prd --dubbo.port=8093 --registry.address=192.168.1.106:2181 --mysql.address=192.168.1.106:3306