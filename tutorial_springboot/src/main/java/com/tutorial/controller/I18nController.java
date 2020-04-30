package com.tutorial.controller;

import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jimmy
 * @date 2020/4/30
 */
@RestController
public class I18nController {
    @Resource
    private MessageSource messageSource;

    @RequestMapping("/i18n")
    public void test(){
        String msg1 = messageSource.getMessage("tutorial_hello",null,LocaleContextHolder.getLocale());
        System.out.println(msg1);
        String msg2 = messageSource.getMessage("message_success",null,LocaleContextHolder.getLocale());
        System.out.println(msg2);
    }
}
