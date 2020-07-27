package com.tutorial.design.pattern.dataaccess;

import java.util.List;

/**
 * 数据访问模式 把低级的数据访问 API 或操作从高级的业务服务中分离出来。以下是数据访问对象模式的参与者。
 * 数据访问对象接口（Data Access Object Interface） - 该接口定义了在一个模型对象上要执行的标准操作。
 * 数据访问对象实体类（Data Access Object concrete class） - 该类实现了上述的接口。该类负责从数据源获取数据，数据源可以是数据库，也可以是 xml，或者是其他的存储机制。
 * 模型对象/数值对象（Model Object/Value Object） - 该对象是简单的 POJO，包含了 get/set 方法来存储通过使用 DAO 类检索到的数据
 * @author jimmy
 * @date 2020/7/19
 */
public class DataAccessPatternDemo {
    public static void main(String[] args) {
        BookDao bookDao = new BookDaoImpl();
        //获取所有
        List<Book> list = bookDao.getAll();
        System.out.println(list);
        //添加
        bookDao.saveBook(new Book(3L,"c"));
        System.out.println(bookDao.getAll());
    }
}
