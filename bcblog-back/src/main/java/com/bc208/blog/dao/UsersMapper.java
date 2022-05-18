package com.bc208.blog.dao;
import com.bc208.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UsersMapper {
    User queryUserByEmail(@Param("uEmail") String uEmail);

    int registerUser(@Param("uEmail") String uEmail,@Param("uPassword") String uPassword);

    int updateUser(@Param("uEmail") String uEmail );
}
