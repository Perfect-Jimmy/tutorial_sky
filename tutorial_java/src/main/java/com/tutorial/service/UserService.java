package com.tutorial.service;

import org.springframework.stereotype.Service;

/**
 * @author jimmy
 * @date 2020/3/24 22:49
 */
@Service
public class UserService {

    public String getUser() throws InterruptedException {
        Thread.sleep(1000*1);
        return "jimmy";
    }

    public int getAge() throws InterruptedException {
        Thread.sleep(1000*4);
        return 28;
    }
}
