package com.wch.course.controller;

import com.wch.course.facade.IMessageFacade;
import com.wch.course.util.BusinessException;
import com.wch.course.util.Response;
import com.wch.course.util.ResponseDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class MessageController {

    @Resource
    private IMessageFacade messageFacade;

    @PostMapping("/verification/{mobile}")
    public Response sendVerificationCode(@PathVariable("mobile") String mobile) {
        try {
            messageFacade.sendSMSMessage(mobile);
            return Response.buildResponse(ResponseDefinition.SUCCESS);
        } catch (BusinessException e) {
            return Response.buildResponse(ResponseDefinition.ERROR, e.getMessage());
        } catch (Exception e) {
            log.error("sendVerificationCode error", e);
            return Response.buildResponse(ResponseDefinition.ERROR);
        }
    }
}
