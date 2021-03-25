package com.example.cjh.mapper;


import com.example.cjh.dto.userDto;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface loginmapper {

    void insertUser(userDto userDto);

    userDto loginUser(String email, String password);


//    userDto findByUser(String email);


}
