package main

import (
	"fmt"
	"git.apache.org/thrift.git/lib/go/thrift"
	"os"
)

const (
	NetworkAddr = "127.0.0.1:19090"
)

type CourseServiceImpl struct {
}

func (this *CourseServiceImpl) SendMobileMessage(mobile string, message string)  {
	fmt.Println("mobile: " + mobile + " message: " + message)
}

func main() {
	transportFactory := thrift.NewTFramedTransportFactory(thrift.NewTTransportFactory())
	protocolFactory := thrift.NewTBinaryProtocolFactoryDefault()
	//protocolFactory := thrift.NewTCompactProtocolFactory()

	serverTransport, err := thrift.NewTServerSocket(NetworkAddr)
	if err != nil {
		fmt.Println("Error!", err)
		os.Exit(1)
	}

	handler := &CourseServiceImpl{}
	processor := rpc.NewRpcServiceProcessor(handler)

	server := thrift.NewTSimpleServer4(processor, serverTransport, transportFactory, protocolFactory)
	fmt.Println("thrift server in", NetworkAddr)
	server.Serve()
}
