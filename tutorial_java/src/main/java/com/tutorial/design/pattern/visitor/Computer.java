package com.tutorial.design.pattern.visitor;

/**
 * @author jimmy
 * @date 2020/7/12
 */
public class Computer implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
