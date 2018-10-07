package com.wch.course.dao.impl;

import com.wch.course.dao.ICourseDao;
import com.wch.course.domain.dto.CourseDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CourseDaoImpl implements ICourseDao {

    @Resource
    private SqlSessionTemplate sst;

    @Override
    public List<CourseDto> selectCourseList() {
        return sst.selectList("course.selectCourseList");
    }
}
