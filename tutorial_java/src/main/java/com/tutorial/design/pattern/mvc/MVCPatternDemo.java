package com.tutorial.design.pattern.mvc;

/**
 * MVC 模式代表 Model-View-Controller（模型-视图-控制器） 模式。这种模式用于应用程序的分层开发
 * https://www.runoob.com/design-pattern/facade-pattern.html
 * mvc 模式
 * @author jimmy
 * @date 2020/7/12
 */
public class MVCPatternDemo {

    public static void main(String[] args) {
        MVCPatternDemo mvcPatternDemo = new MVCPatternDemo();
        //1.数据库获取数据model
        Student student = mvcPatternDemo.getFromDataBase();
        //2.创建视图,输出详情
        StudentView studentView = new StudentView();
        StudentController studentController = new StudentController(student,studentView);
        //3.输出详情
        studentController.updateView();


        //精髓--更新名字
        studentController.setStudentName("lucy");
        studentController.updateView();
    }


    public Student getFromDataBase(){
        Student student = new Student();
        student.setId(1L);
        student.setName("jimmy");
        return student;
    }
}
