package com.tutorial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: jimmy
 * @Date: 2020/3/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Integer id;
    private String province;
    private String city;
    private Address address;
}
