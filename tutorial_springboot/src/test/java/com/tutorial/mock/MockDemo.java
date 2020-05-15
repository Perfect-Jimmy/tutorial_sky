package com.tutorial.mock;

import com.tutorial.AppStart;
import com.tutorial.entity.User;
import com.tutorial.repository.UserRepository;
import com.tutorial.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jimmy
 * @date 2020/5/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppStart.class)
public class MockDemo {
    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    //Mockito限制
    //不能 Mock 静态方法
    //不能 Mock private 方法
    //不能 Mock final class

    //如果 userRepository 还没写好，又想先测 userService 的话，就需要使用 Mockito 去模拟一个假的 userRepository 出来
    //Mockito.when( 对象.方法名() ).thenReturn( 自定义结果 )

    //限制只有当参数的数字是 3 时，才会回传名字为 I'm mock 3 的 user 对象
    @Test
    public void mock1(){
        // 定义当调用mock userRepository的getUserById()方法，并且参数为3时，就返回id为200、name为I'm mock3的user对象
        Mockito.when(userRepository.getUserById(3)).thenReturn(new User(200, "I'm mock 3"));

        // 返回的会是名字为I'm mock 3的user对象
        User user = userService.getUserById(3);

        Assert.assertNotNull(user);
        Assert.assertEquals(user.getId(), new Integer(200));
        Assert.assertEquals(user.getName(), "I'm mock 3");
    }

    //当使用任何整数值调用 userService 的 getUserById() 方法时，就回传一个名字为 I'm mock3 的 User 对象
    @Test
    public void mock2(){
        Mockito.when(userRepository.getUserById(Mockito.anyInt())).thenReturn(new User(200, "I'm mock 3"));
        // 返回的会是名字为I'm mock 3的user对象
        User user1 = userService.getUserById(3);
        System.out.println(user1.getName());
        User user2 = userService.getUserById(4);
        System.out.println(user2.getName());
    }

    //当调用 userService 的 insertUser() 方法时，不管传进来的 user 是什么，都回传 100
    @Test
    public void mock3(){
        Mockito.when(userService.insertUser(Mockito.any(User.class))).thenReturn(100);
        Integer i = userService.insertUser(new User()); //会返回100
        Assert.assertEquals(i,new Integer(100));
    }

    //当调用 userService 的 getUserById() 时的参数是 9 时，抛出一个 RuntimeException
    @Test
    public void mock4(){
        Mockito.when(userService.getUserById(9)).thenThrow(new RuntimeException("mock throw exception"));
        User user = userService.getUserById(9); //会抛出一个RuntimeException
    }
    //如果方法没有返回值的话（即是方法定义为 public void myMethod() {...}），要改用 doThrow() 抛出 Exception
    //Mockito.doThrow(new RuntimeException("mock throw exception")).when(userService).print();
    //userService.print(); //会抛出一个RuntimeException


/*
        verify 系列方法

        检查调用 userService 的 getUserById()、且参数为3的次数是否为1次。

                Mockito.verify(userService, Mockito.times(1)).getUserById(Mockito.eq(3)) ;
        验证调用顺序，验证 userService 是否先调用 getUserById() 两次，并且第一次的参数是 3、第二次的参数是 5，然后才调用insertUser() 方法。

        InOrder inOrder = Mockito.inOrder(userService);
    inOrder.verify(userService).getUserById(3);
    inOrder.verify(userService).getUserById(5);
    inOrder.verify(userService).insertUser(Mockito.any(User.class));*/
}
