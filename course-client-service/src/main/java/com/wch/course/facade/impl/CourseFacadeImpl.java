package com.wch.course.facade.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wch.course.domain.dto.CourseDto;
import com.wch.course.facade.ICourseFacade;
import com.wch.course.service.dubbo.ICourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseFacadeImpl implements ICourseFacade {

    @Reference
    private ICourseService courseService;

    @Override
    public List<CourseDto> queryCourseList() {
        return courseService.queryCourseList();
    }

}
