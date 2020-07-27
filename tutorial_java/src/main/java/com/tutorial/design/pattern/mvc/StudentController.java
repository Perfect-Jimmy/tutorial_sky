package com.tutorial.design.pattern.mvc;

import lombok.Data;

/**
 * @author jimmy
 * @date 2020/7/12
 */
//@Data
public class StudentController {
    private Student student;
    private StudentView studentView;

    //构造函数
    public StudentController(Student student,StudentView studentView){
        this.student = student;
        this.studentView = studentView;
    }

    public void setStudentId(Long id){
        student.setId(id);
    }

    public Long getStudentId(){
        return student.getId();
    }


    public void setStudentName(String name){
        student.setName(name);
    }

    public String getStudentName(){
        return student.getName();
    }

    //更新视图
    public void updateView(){
        studentView.showStudent(student.getId(),student.getName());
    }
}
