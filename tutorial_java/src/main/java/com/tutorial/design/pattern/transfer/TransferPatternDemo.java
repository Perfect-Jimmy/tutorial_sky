package com.tutorial.design.pattern.transfer;

import java.util.List;

/**
 * 传输对象模式 用于从客户端向服务器一次性传递带有多个属性的数据
 * 业务对象 为传输对象填充数据的业务服务
 * 传输对象 简单的pojo,只有get、set方法
 * client
 * @author jimmy
 * @date 2020/7/19
 */
public class TransferPatternDemo {
    public static void main(String[] args) {
        StudentBusinessBO bo = new StudentBusinessBO();
        //获取所有
        List<StudentVO> list = bo.getAll();
        System.out.println(list);
        //删除jimmy  注意要实现equals和hashcode方法
        bo.delStudent(new StudentVO("jimmy",19));
        list = bo.getAll();
        System.out.println(list.size());
    }
}
