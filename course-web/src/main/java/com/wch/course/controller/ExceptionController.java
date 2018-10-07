package com.wch.course.controller;

import com.wch.course.util.Response;
import com.wch.course.util.ResponseDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        log.error("handleException", e);
        return Response.buildResponse(ResponseDefinition.ERROR);
    }
}
