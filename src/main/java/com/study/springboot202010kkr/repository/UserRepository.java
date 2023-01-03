package com.study.springboot202010kkr.repository;

import com.study.springboot202010kkr.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    public int saveUser(UserDto userDto);
    public UserDto findUserByUserId(int userId);
    public UserDto findUserByUsername(String username);

//    public List<UserDto> getUsers();

}
