package com.tutorial.pojo;


import lombok.Data;

/**
 * @author jimmy
 * @date 2020/4/1 14:10
 */
@Data
public class User {
    private Integer id;
    private String name;
    private Address address;
}

@Data
class Address{
    private Integer id;
    private String province;
    private String city;
}
