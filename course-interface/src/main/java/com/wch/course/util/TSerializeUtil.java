package com.wch.course.util;

import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TSimpleJSONProtocol;

/**
 * thrift序列化工具
 */
public class TSerializeUtil {

    /**
     * 默认二进制序列化
     */
    private static final TSerializer T_SERIALIZER = new TSerializer();

    /**
     * 默认二进制反序列化
     */
    private static final TDeserializer T_DESERIALIZER = new TDeserializer();

    /**
     * json格式序列化
     */
    private static final TSerializer JSON_SERIALIZER = new TSerializer(new TSimpleJSONProtocol.Factory());

    /**
     * json格式反序列化
     */
    private static final TDeserializer JSON_DESERIALIZER = new TDeserializer(new TSimpleJSONProtocol.Factory());

    /**
     * 二进制序列化
     *
     * @param tBase
     * @return
     * @throws TException
     */
    public static byte[] serialize(TBase tBase) throws TException {
        return T_SERIALIZER.serialize(tBase);
    }

    /**
     * 二进制反序列化
     *
     * @param tBase
     * @param src
     * @throws TException
     */
    public static void deSerialize(TBase tBase, byte[] src) throws TException {
        T_DESERIALIZER.deserialize(tBase, src);
    }

    /**
     * json格式序列化
     *
     * @param tBase
     * @return
     * @throws TException
     */
    public static byte[] serializeJson(TBase tBase) throws TException {
        return JSON_SERIALIZER.serialize(tBase);
    }

    /**
     * json格式反序列化
     *
     * @param tBase
     * @param src
     * @throws TException
     */
    public static void deSerializeJson(TBase tBase, byte[] src) throws TException {
        JSON_DESERIALIZER.deserialize(tBase, src);
    }
}
