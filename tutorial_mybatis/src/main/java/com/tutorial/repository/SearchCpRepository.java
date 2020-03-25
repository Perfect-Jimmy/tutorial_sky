package com.tutorial.repository;

import com.tutorial.model.SearchCp;
import com.tutorial.repository.mapper.SearchCpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: jimmy
 * @Date: 2020/3/25
 */
@Repository
public class SearchCpRepository {
    @Autowired
    SearchCpMapper searchCpMapper;

    public SearchCp findById(Long id){
        return searchCpMapper.findById(id);
    }
}
