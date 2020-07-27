package com.tutorial.design.pattern.transfer;

import java.util.Objects;

/**
 * 传输对象 数据库查询出来 可序列化
 * @author jimmy
 * @date 2020/7/19
 */
public class StudentVO {

    private String name;
    private int age;

    public StudentVO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentVO studentVO = (StudentVO) o;
        return age == studentVO.age &&
                Objects.equals(name, studentVO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
