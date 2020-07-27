package com.tutorial.design.pattern.visitor;

/**
 * 访问者接口
 * @author jimmy
 * @date 2020/7/12
 */
public interface ComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Mouse mouse);
}
