package com.tutorial.design.pattern.transfer;

import com.tutorial.design.pattern.mvc.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务对象
 * @author jimmy
 * @date 2020/7/19
 */
public class StudentBusinessBO {
    //模拟数据库列表
    List<StudentVO> students;

    public StudentBusinessBO(){
        students = new ArrayList<>();
        StudentVO vo1 = new StudentVO("jimmy",19);
        StudentVO vo2 = new StudentVO("lucy",20);
        students.add(vo1);
        students.add(vo2);
    }

    /**
     * 获取所有
     * @return java.util.List<com.tutorial.design.pattern.transfer.StudentVO>
     * @author jimmy
     * @date 2020/7/19
     */
    public List<StudentVO> getAll(){
        return students;
    }

    /**
     * 查询
     * @param name
     * @return com.tutorial.design.pattern.transfer.StudentVO
     * @author jimmy
     * @date 2020/7/19
     */
    public StudentVO getStudentByName(String name){
        return null;
    }

    /**
     * 删除
     * @param studentVO
     * @return void
     * @author jimmy
     * @date 2020/7/19
     */
    public void delStudent(StudentVO studentVO){
        students.remove(studentVO);
    }

    /**
     * 更新
     * @param studentVO
     * @return com.tutorial.design.pattern.transfer.StudentVO
     * @author jimmy
     * @date 2020/7/19
     */
    public StudentVO updateStudent(StudentVO studentVO){
        return null;
    }
}
