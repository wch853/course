package com.wch.course.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wch.course.dao.ICourseDao;
import com.wch.course.domain.dto.CourseDto;
import com.wch.course.service.dubbo.ICourseService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Resource
    private ICourseDao courseDao;

    @Override
    public List<CourseDto> queryCourseList() {
        return courseDao.selectCourseList();
    }
}
