package rpc

import (
	"course/rpc/impl"
	"course/rpc/service"
	"log"
	"git.apache.org/thrift.git/lib/go/thrift"
	"flag"
)

var Host string

func init()  {
	flag.StringVar(&Host, "host", "localhost:8082", "thrift port")
	flag.Parse()
}

func Start() {
	handler := &impl.MessageServiceImpl{}
	serviceProcessor := service.NewIMessageServiceProcessor(handler)
	socket, err := thrift.NewTServerSocket(Host)
	if nil != err {
		panic(err)
	}
	transportFactory := thrift.NewTFramedTransportFactory(thrift.NewTTransportFactory())
	protocolFactory := thrift.NewTBinaryProtocolFactoryDefault()

	server := thrift.NewTSimpleServer4(serviceProcessor, socket, transportFactory, protocolFactory)
	log.Printf("thrift server in %s", Host)
	server.Serve()
}
