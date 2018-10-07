package main

import (
	"course/rpc"
	"net/http"
	"course/web"
)

func main() {
	go func() {
		rpc.Start()
	}()

	http.HandleFunc("/send", web.HandleHttpRequest)
	err := http.ListenAndServe(":8089", nil)
	if nil != err {
		panic(err)
	}
}
