package com.wch.course.controller;

import com.wch.course.domain.dto.UserDto;
import com.wch.course.facade.IUserFacade;
import com.wch.course.util.BusinessException;
import com.wch.course.util.Response;
import com.wch.course.util.ResponseDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserFacade userFacade;

    @PostMapping(value = "/login")
    public Response login(@RequestBody UserDto userDto) {
        try {
            return Response.buildResponse(userFacade.handleUserLogin(userDto), ResponseDefinition.SUCCESS);
        } catch (BusinessException e) {
            return Response.buildResponse(ResponseDefinition.ERROR, e.getMessage());
        } catch (Exception e) {
            log.error("login Exception", e);
            return Response.buildResponse(ResponseDefinition.ERROR);
        }
    }

    @PostMapping("/registry/{verificationCode}")
    public Response register(@RequestBody UserDto userDto, @PathVariable("verificationCode") String verificationCode) {
        try {
            userFacade.registerUser(userDto, verificationCode);
            return Response.buildResponse(ResponseDefinition.SUCCESS);
        } catch (BusinessException e) {
            return Response.buildResponse(ResponseDefinition.ERROR, e.getMessage());
        } catch (Exception e) {
            log.error("register Exception", e);
            return Response.buildResponse(ResponseDefinition.ERROR);
        }
    }

}
