FROM golang:latest
LABEL maintainer="wch wch@163.com"

COPY src/course $GOPATH/src/course

WORKDIR $GOPATH/src/course

# TODO 下载go thrift依赖
RUN go build .

ENTRYPOINT ["./main"]