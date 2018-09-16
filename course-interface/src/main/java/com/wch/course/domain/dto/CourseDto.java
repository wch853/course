package com.wch.course.domain.dto;

import java.io.Serializable;

public class CourseDto implements Serializable {

    /**
     * 课程编号
     */
    private Integer id;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程描述
     */
    private String description;

    /**
     * 教师编号
     */
    private Integer teacherId;

    private TeacherDto teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public TeacherDto getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDto teacher) {
        this.teacher = teacher;
    }
}
