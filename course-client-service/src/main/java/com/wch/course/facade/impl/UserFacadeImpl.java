package com.wch.course.facade.impl;

import com.wch.course.cache.RedisClient;
import com.wch.course.constant.Constants;
import com.wch.course.domain.dto.LoginDto;
import com.wch.course.domain.dto.UserDto;
import com.wch.course.facade.IUserFacade;
import com.wch.course.thrift.ThriftClient;
import com.wch.course.thrift.domain.UserInfo;
import com.wch.course.util.BusinessException;
import com.wch.course.util.CodeUtil;
import com.wch.course.util.TSerializeUtil;
import org.apache.thrift.TException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

@Service
public class UserFacadeImpl implements IUserFacade {

    @Resource
    private ThriftClient thriftClient;

    @Resource
    private RedisClient redisClient;

    @Override
    public LoginDto handleUserLogin(UserDto userDto) throws Exception {
        try {
            // 验证用户信息
            UserInfo userInfo = thriftClient.getUserService().queryUserByName(userDto.getUsername());
            Assert.notNull(userInfo, "无效用户！");
            Assert.state(userInfo.getPassword().equals(DigestUtils.md5DigestAsHex(userDto.getPassword()
                    .getBytes())), "密码错误！");

            // 生成token
            String token = CodeUtil.getToken();

            // 用户信息写入缓存
            this.setTokenCache(token, userInfo);

            // 返回用户token信息
            LoginDto loginDto = new LoginDto();
            loginDto.setToken(token);
            loginDto.setUsername(userDto.getUsername());
            return loginDto;
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw new BusinessException(e);
        }
    }

    private void setTokenCache(String token, UserInfo userInfo) throws TException {
        userInfo.setPassword(null);
        redisClient.set(Constants.USE_TOKEN_CACHE_PREFIX.concat(token).getBytes(), TSerializeUtil.serialize(userInfo),
                Constants.USE_TOKEN_EXPIRE_TIME);
    }

    @Override
    public LoginDto registerUser(UserDto userDto, String verificationCode) throws Exception {
        try {
            Assert.notNull(verificationCode, "验证码不可为空！");
            Assert.notNull(userDto.getMobile(), "手机号不可为空！");
            String codeInCache = (String) redisClient.get(Constants.VERIFICATION_CODE_CACHE_PREFIX
                    .concat(userDto.getMobile().toString()));
            Assert.state(verificationCode.equals(codeInCache), "验证码有误！");

            Assert.notNull(userDto.getUsername(), "用户名不可为空！");
            Assert.notNull(userDto.getPassword(), "密码不可为空！");
            Assert.notNull(userDto.getRealName(), "真实姓名不可为空！");
            Assert.notNull(userDto.getEmail(), "电子邮箱不可为空！");

            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(userDto, userInfo, "id", "password");
            userInfo.setPassword(DigestUtils.md5DigestAsHex(userDto.getPassword().getBytes()));
            thriftClient.getUserService().addUser(userInfo);

            String token = CodeUtil.getToken();
            this.setTokenCache(token, userInfo);

            // 返回用户token信息
            LoginDto loginDto = new LoginDto();
            loginDto.setToken(token);
            loginDto.setUsername(userDto.getUsername());
            return loginDto;
        } catch (IllegalArgumentException e) {
            throw new BusinessException(e);
        }
    }

}
