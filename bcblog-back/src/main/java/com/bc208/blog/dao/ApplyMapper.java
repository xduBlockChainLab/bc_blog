package com.bc208.blog.dao;


import com.bc208.blog.pojo.Apply;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplyMapper {

    void insertApply(Apply apply);
}
