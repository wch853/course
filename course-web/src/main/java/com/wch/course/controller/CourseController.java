package com.wch.course.controller;

import com.wch.course.facade.ICourseFacade;
import com.wch.course.util.BusinessException;
import com.wch.course.util.Response;
import com.wch.course.util.ResponseDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private ICourseFacade courseFacade;

    @GetMapping("/query")
    public Response queryCourseList() {
        try {
            return Response.buildResponse(courseFacade.queryCourseList(), ResponseDefinition.SUCCESS);
        } catch (BusinessException e) {
            return Response.buildResponse(ResponseDefinition.ERROR, e.getMessage());
        } catch (Exception e) {
            log.error("queryCourseList Exception", e);
            return Response.buildResponse(ResponseDefinition.ERROR);
        }
    }
}
