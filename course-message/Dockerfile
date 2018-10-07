FROM golang:latest
LABEL maintainer="wch wch@163.com"

COPY src/ $GOPATH/src/

WORKDIR $GOPATH/src/course

RUN go build main.go

ENTRYPOINT ["./main"]