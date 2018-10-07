package rpc

import (
	"git.apache.org/thrift.git/lib/go/thrift"
	"course/rpc/service"
)

func GetClient() (*service.IMessageServiceClient, thrift.TTransport, error) {
	socket, err := thrift.NewTSocket(Host)
	if nil != err {
		return nil, nil, err
	}
	transportFactory := thrift.NewTFramedTransportFactory(thrift.NewTTransportFactory())
	transport, err := transportFactory.GetTransport(socket)
	if err != nil {
		return nil, nil, err
	}
	protocolFactory := thrift.NewTBinaryProtocolFactoryDefault()
	tBinaryProtocol := protocolFactory.GetProtocol(transport)
	standardClient := thrift.NewTStandardClient(tBinaryProtocol, tBinaryProtocol)
	client := service.NewIMessageServiceClient(standardClient)
	return client, transport, nil
}
