package com.tutorial.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author jimmy
 * @description
 * @date 2020/4/14 14:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Car {
    private Long id;
    private String name;
    private Long price;
}
