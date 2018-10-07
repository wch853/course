docker build -t course-message:1.0 .

REM docker run -d --name course-message --host=localhost:8083 -p 8089:8089 course-message:1.0