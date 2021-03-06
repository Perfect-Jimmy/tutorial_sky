package com.tutorial.vo;

import lombok.Data;
import org.dozer.Mapping;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author jimmy
 * @date 2020/3/25 23:44
 */
@Data
public class UserVo {
    private Integer userId;
    private String name;
    private Date birth;
}
