package com.tutorial.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.tutorial.excel.listener.ExcelCustomConvert;

/**
 * @author jimmy
 * @date 2020/4/2 18:18
 */
public class ExcelUserPo {
    /**
     * value: 表头名称
     * index: 列的号, 0表示第一列
     */
    @ExcelProperty(value = "姓名",converter = ExcelCustomConvert.class)
    private String userName;

    @ExcelProperty(value = "年龄")
    private String age;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ExcelUserPo{" +
                "userName='" + userName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
