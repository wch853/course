mvn clean package -DskipTests=true && docker build -t course-thrift-server:1.0 .

REM docker run -it course-thrift-server:1.0 --spring.profiles.active=prd --rpc.thrift.port=8081 --mysql.address=192.168.1.106:3306