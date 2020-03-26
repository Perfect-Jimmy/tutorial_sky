package com.tutorial.repository.mapper;

import com.tutorial.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: jimmy
 * @Date: 2020/3/25
 */
//@Mapper
public interface UserMapper {
    User findById(@Param("id") Long id);
}
