mvn clean package && docker build -t course-rpc-server:1.0 .

REM docker run -it course-rpc-server:1.0 --spring.profiles.active=prd --rpc.thrift.port=8081 --dubbo.port=8093 --registry.address=192.168.1.106:2181 --mysql.address=192.168.1.106:3306