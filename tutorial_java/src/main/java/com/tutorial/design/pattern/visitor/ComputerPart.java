package com.tutorial.design.pattern.visitor;

/**
 * 元素接口
 * @author jimmy
 * @date 2020/7/12
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
