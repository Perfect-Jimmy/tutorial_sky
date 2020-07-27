package com.tutorial.design.pattern.mvc;

/**
 * @author jimmy
 * @date 2020/7/12
 */
public class StudentView {

    /**
     * 视图
     * @param id
     * @param name
     * @return void
     * @author jimmy
     * @date 2020/7/12
     */
    public void showStudent(Long id,String name){
        System.out.println("student id "+id);
        System.out.println("student name "+name);
    }
}
