package com.tutorial.lambda;

/**
 * 函数式编程
 * java面向对象编程
 * @author jimmy
 * @date 2020/3/26 23:38
 */
public class Demo1 {
    public static void main(String[] args) {
        //匿名内部类，接口new----不优雅
        Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("Hello");
            }
        };
        foo.sayHello();
        //-------------------------
        //函数式编程 不带参数和返回值
        Foo f = () -> {
            System.out.println("jimmy");
        };
        f.sayHello();
        //函数式编程 带参数和返回值
        Math math = (int x,int y) -> {return x+y;};
        int result = math.add(1,2);
        System.out.println(result);
    }
}


/**
 * java面向接口编程  只能定义一个方法
 */
interface Foo{
    public void sayHello();
}

@FunctionalInterface
interface Math{
    public int add(int x,int y);

    //default方法可以有多个
    public default int mull(int x,int y){
        return x*y;
    }
    public default int mull2(int x,int y){
        return x*y;
    }

    //static法可以有多个
    public static int div(int x,int y){
        return x/y;
     }
    public static int div2(int x,int y){
        return x/y;
    }
}
