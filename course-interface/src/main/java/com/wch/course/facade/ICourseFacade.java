package com.wch.course.facade;

import com.wch.course.domain.dto.CourseDto;

import java.util.List;

public interface ICourseFacade {

    List<CourseDto> queryCourseList();

}
