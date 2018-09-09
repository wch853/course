package com.wch.course.facade.impl;

import com.wch.course.cache.RedisClient;
import com.wch.course.constant.Constants;
import com.wch.course.facade.IMessageFacade;
import com.wch.course.thrift.ThriftClient;
import com.wch.course.util.BusinessException;
import com.wch.course.util.CodeUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@Service
public class MessageFacadeImpl implements IMessageFacade {

    @Resource
    private ThriftClient thriftClient;

    @Resource
    private RedisClient redisClient;

    @Override
    public void sendSMSMessage(String mobile) throws Exception {
        try {
            // 获取和发送验证码
            String verificationCode = CodeUtil.getVerificationCode();
            String message = "验证码为：".concat(verificationCode);
            boolean isSuccess = thriftClient.getMessageService().sendSMSMessage(mobile, message);
            Assert.state(isSuccess, "验证码发送失败！");

            // 将验证码写入缓存
            redisClient.set(Constants.VERIFICATION_CODE_CACHE_PREFIX.concat(mobile), verificationCode,
                    Constants.VERIFICATION_CODE_EXPIRE_TIME);
        } catch (IllegalStateException e) {
            throw new BusinessException(e);
        }
    }
}
