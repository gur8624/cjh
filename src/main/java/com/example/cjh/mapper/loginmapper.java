package com.example.cjh.mapper;


import com.example.cjh.dto.userDto;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface loginmapper {

    void insertUser(userDto userDto);

    userDto loginUser(userDto userDto);

    void updateUser(userDto userDto);

    userDto findUser(userDto userDto);


}
