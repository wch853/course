package com.wch.course.service.dubbo;

import com.wch.course.domain.dto.CourseDto;

import java.util.List;

public interface ICourseService {

    List<CourseDto> queryCourseList();
}
