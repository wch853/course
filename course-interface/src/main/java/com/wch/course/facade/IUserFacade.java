package com.wch.course.facade;

import com.wch.course.domain.dto.LoginDto;
import com.wch.course.domain.dto.UserDto;

public interface IUserFacade {

    /**
     * 用户登录
     *
     * @param userDto
     * @return
     * @throws Exception
     */
    LoginDto handleUserLogin(UserDto userDto) throws Exception;

    /**
     * 用户注册
     *
     * @param userDto
     * @param verificationCode
     * @return
     * @throws Exception
     */
    LoginDto registerUser(UserDto userDto, String verificationCode) throws Exception;
}
