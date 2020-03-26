package com.tutorial.controller;

import com.tutorial.common.util.DozerUtil;
import com.tutorial.pojo.UserPo;
import com.tutorial.vo.UserVo;
import org.assertj.core.util.Lists;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jimmy
 * @date 2020/3/25 23:45
 */
@RestController
public class DozerController {
    @Autowired
    Mapper dozerBeanMapper;

    /**
     * 对象转换
     * @return
     */
    @RequestMapping("/dozerTest")
    public String dozerTest(){
        UserPo userPo = new UserPo().setId(1).setName("Jimmy").setAge(22);
        UserVo userVo = dozerBeanMapper.map(userPo,UserVo.class);
        System.out.println(userVo);
        return "";
    }

    /**
     * 对象list转换
     * @return
     */
    @RequestMapping("/dozerListTest")
    public String dozerListTest(){
        UserPo userPo1 = new UserPo().setId(1).setName("Jimmy").setAge(22);
        UserPo userPo2 = new UserPo().setId(2).setName("lucy").setAge(22);
        List<UserPo> userPoList = Lists.newArrayList();
        userPoList.add(userPo1);
        userPoList.add(userPo2);
        List<UserVo> userVoList = DozerUtil.mappperList(userPoList,UserVo.class);
        System.out.println(userVoList);
        return "";
    }
}
