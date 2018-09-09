package com.wch.course.dao;

import com.wch.course.domain.dto.CourseDto;

import java.util.List;

public interface ICourseDao {
    
    List<CourseDto> selectCourseList();
}
