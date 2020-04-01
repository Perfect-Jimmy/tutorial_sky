package com.tutorial.multithread.test;


import com.tutorial.JavaTutorialStart;
import com.tutorial.multithread.core.CustomFutureTask;
import com.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.util.StopWatch;

import java.util.concurrent.*;

/**
 * @author jimmy
 * @date 2020/3/24 22:15
 */
@SpringJUnitConfig()
//@ContextConfiguration("classpath:applicationContext.xml")
@SpringBootTest(classes = JavaTutorialStart.class)
public class FutureTaskTest {
    @Autowired
    UserService userService;

    /**
     * StopWatch 'one': running time (millis) = 6009; [] took 6009 = 100%
     * @throws InterruptedException
     */
   // @Test
    public void test1() throws InterruptedException {
        /**
         * 没有使用异步---多线程
         */
        StopWatch stopWatch = new StopWatch("one");
        stopWatch.start();
        String name = userService.getUser();
        int age = userService.getAge();
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println(name+"="+age);
    }

    /**
     * StopWatch 'two': running time (millis) = 4004
     * -----------------------------------------
     * ms     %     Task name
     * -----------------------------------------
     * 00002  000%  task1
     * 04002  100%  task2
     * @throws InterruptedException
     */
   // @Test
    public void test2() throws InterruptedException, ExecutionException {
        /**
         * 使用线程池
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        StopWatch stopWatch = new StopWatch("two");
        stopWatch.start("task1");
        Callable<String> callName = new Callable<String>() {
            public String call() throws Exception {
                return userService.getUser();
            }
        };
        stopWatch.stop();
        stopWatch.start("task2");
        Callable<Integer> callAge = new Callable<Integer>() {
            public Integer call() throws Exception {
                return userService.getAge();
            }
        };
        Future<String> nameFuture = executorService.submit(callName);
        Future<Integer> ageFuture = executorService.submit(callAge);
        System.out.println(nameFuture.get()+"="+ageFuture.get());
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    /**
     * callable返回原理?callable的call方法就是在run方法中执行的！！！！
     * @throws InterruptedException
     * @throws ExecutionException
     */
   // @Test
    public void test3() throws InterruptedException, ExecutionException {
        /**
         * 不使用线程池
         */
        StopWatch stopWatch = new StopWatch("three");
        stopWatch.start("task1");
        Callable<String> callName = new Callable<String>() {
            public String call() throws Exception {
                return userService.getUser();
            }
        };
        stopWatch.stop();
        stopWatch.start("task2");
        Callable<Integer> callAge = new Callable<Integer>() {
            public Integer call() throws Exception {
                return userService.getAge();
            }
        };
        //对比利用线程池
        FutureTask<String> nameFuture = new FutureTask<String>(callName);
        FutureTask<Integer> ageFuture = new FutureTask<Integer>(callAge);
        new Thread(nameFuture).start();
        new Thread(ageFuture).start();
        System.out.println(nameFuture.get()+"="+ageFuture.get());
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    /**
     * 自定义futureTask
     * @throws InterruptedException
     * @throws ExecutionException
     */
  //  @Test
    public void test4() throws InterruptedException, ExecutionException {
        StopWatch stopWatch = new StopWatch("four");
        stopWatch.start("task1");
        Callable<String> callName = new Callable<String>() {
            public String call() throws Exception {
                return userService.getUser();
            }
        };
        stopWatch.stop();
        stopWatch.start("task2");
        Callable<Integer> callAge = new Callable<Integer>() {
            public Integer call() throws Exception {
                return userService.getAge();
            }
        };
        //对比利用线程池
        CustomFutureTask<String> nameFuture = new CustomFutureTask<String>(callName);
        CustomFutureTask<Integer> ageFuture = new CustomFutureTask<Integer>(callAge);
        new Thread(nameFuture).start();
        new Thread(ageFuture).start();
        System.out.println(nameFuture.get()+"="+ageFuture.get());
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
