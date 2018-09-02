package com.wch.course;

import org.springframework.util.DigestUtils;
import org.testng.annotations.Test;

@Test
public class MyTest {

    public void testGetPassword() {
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
        // e10adc3949ba59abbe56e057f20f883e
    }

    public void testThrift() {
    }

}
