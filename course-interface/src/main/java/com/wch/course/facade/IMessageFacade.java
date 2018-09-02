package com.wch.course.facade;

public interface IMessageFacade {

    /**
     * 发送手机验证码
     *
     * @param mobile
     * @throws Exception
     */
    void sendSMSMessage(String mobile) throws Exception;
}
