package web

import (
	"net/http"
	"log"
	"context"
	"course/rpc/service"
	"git.apache.org/thrift.git/lib/go/thrift"
	"course/rpc"
)

var client *service.IMessageServiceClient
var transport thrift.TTransport

func HandleHttpRequest(writer http.ResponseWriter, request *http.Request) {
	if nil == client || nil == transport {
		client, transport, _ = rpc.GetClient()
	}

	if err := transport.Open(); nil != err {
		log.Printf("error: %v", err)
	}

	mobile := request.FormValue("mobile")
	message := request.FormValue("message")

	client.SendSMSMessage(context.Background(), mobile, message)
	transport.Close()

	writer.Write([]byte("send success!"))
}
