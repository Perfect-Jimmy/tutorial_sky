package com.tutorial.repository.mapper;

import com.tutorial.model.SearchCp;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: jimmy
 * @Date: 2020/3/25
 */
public interface SearchCpMapper {
    SearchCp findById(@Param("id") Long id);
}
