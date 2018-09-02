package com.wch.course.thrift;

import com.wch.course.service.thrift.IMessageService;
import com.wch.course.service.thrift.IUserService;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

@Component
public class ThriftClient {

    @Value("${thrift.service.timeout}")
    private int timeout;

    @Value("${thrift.service.user.ip}")
    private String userServiceIp;

    @Value("${thrift.service.user.port}")
    private int userServicePort;

    @Value("${thrift.service.message.ip}")
    private String messageServiceIp;

    @Value("${thrift.service.message.port}")
    private int messageServicePort;

    /**
     * 获取服务
     *
     * @param ip
     * @param port
     * @param timeout
     * @param clazz
     * @return
     * @throws Exception
     */
    private TServiceClient getService(String ip, int port, int timeout, Class<? extends TServiceClient> clazz) throws Exception {
        TSocket socket = new TSocket(ip, port, timeout);
        TFramedTransport transport = new TFramedTransport(socket);
        transport.open();
        TBinaryProtocol tBinaryProtocol = new TBinaryProtocol(transport);
        Constructor<? extends TServiceClient> constructor = clazz.getConstructor(TProtocol.class);
        return constructor.newInstance(tBinaryProtocol);
    }

    public IUserService.Client getUserService() throws Exception {
        return (IUserService.Client) getService(userServiceIp, userServicePort, timeout, IUserService.Client.class);
    }

    public IMessageService.Client getMessageService() throws Exception {
        return (IMessageService.Client) getService(messageServiceIp, messageServicePort, timeout, IMessageService.Client.class);
    }

}
