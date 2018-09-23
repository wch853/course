package com.wch.course.controller;

import com.wch.course.util.Response;
import com.wch.course.util.ResponseDefinition;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public Response handleException() {
        return Response.buildResponse(ResponseDefinition.ERROR);
    }
}
