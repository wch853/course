package com.wch.course.thrift;

import com.wch.course.service.thrift.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Slf4j
@Component
public class ThriftServer {

    @Value("${thrift.port}")
    private int thriftServicePort;

    @Resource
    private IUserService.Iface userService;

    @PostConstruct
    public void startThriftServer() {
        TProcessor processor = new IUserService.Processor<>(userService);
        TNonblockingServerSocket socket = null;
        try {
            socket = new TNonblockingServerSocket(thriftServicePort);
        } catch (TTransportException e) {
            log.error("start thrift server error", e);
        }

        TNonblockingServer.Args args = new TNonblockingServer.Args(socket);
        args.processor(processor);
        args.transportFactory(new TFramedTransport.Factory());
        args.protocolFactory(new TBinaryProtocol.Factory());

        TServer server = new TNonblockingServer(args);
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("thrift server start ...");
                server.serve();
            }
        }).start();
    }
}
