package com.wch.course;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wch.course.domain.dto.UserDto;
import com.wch.course.domain.thrift.UserInfo;
import com.wch.course.util.JsonUtil;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TSimpleJSONProtocol;
import org.springframework.util.DigestUtils;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class MyTest {

    public void testGetPassword() {
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
        // e10adc3949ba59abbe56e057f20f883e
    }

    public void testThrift() throws TException, IOException {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setPassword("123");
        userInfo.setUsername("wch");

        TSerializer tSerializer = new TSerializer(new TSimpleJSONProtocol.Factory());
        byte[] bytes = tSerializer.serialize(userInfo);
        System.out.println(new String(bytes));

        TDeserializer tDeserializer = new TDeserializer(new TSimpleJSONProtocol.Factory());
        UserInfo base = new UserInfo();
        tDeserializer.deserialize(base, bytes);


        ObjectMapper objectMapper = new ObjectMapper();

        UserInfo userInfoX = objectMapper.readValue(bytes, UserInfo.class);
        System.out.println(JsonUtil.toJsonString(userInfoX));

        UserDto userDto = objectMapper.readValue(bytes, UserDto.class);
        System.out.println(JsonUtil.toJsonString(userDto));
    }

}
