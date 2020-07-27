package com.tutorial.design.pattern.visitor;

/**
 * 具体访问者
 * @author jimmy
 * @date 2020/7/12
 */
public class ComputerDisplayVisitor implements ComputerPartVisitor{
    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying mouse.");
    }
}
