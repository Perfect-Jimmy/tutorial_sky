package com.tutorial.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.dozer.Mapping;

/**
 * @author jimmy
 * @date 2020/3/25 23:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserPo {
    @Mapping("userId")
    private Integer id;
    private String name;
    private int age;
}
