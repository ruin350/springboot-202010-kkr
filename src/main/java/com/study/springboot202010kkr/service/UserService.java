package com.study.springboot202010kkr.service;

import com.study.springboot202010kkr.repository.UserRepository;
import com.study.springboot202010kkr.web.Exception.CustomDuplicateUsernameException;
import com.study.springboot202010kkr.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public int addUser(UserDto userDto) {
        int userId = 0;
        System.out.println("데이터베이스에 insert 전 : " + userDto);
        userId = userRepository.saveUser(userDto);
        System.out.println("데이터베이스에 insert 후 : " + userDto);
        return userDto.getUserId();
    }

    public UserDto getUser(int userId) {
        UserDto userDto = null;
        userDto = userRepository.findUserByUserId(userId);
        return userDto;
    }

    // 아이디 중복확인
    public void duplicateUsername(String username) {
        UserDto userDto = userRepository.findUserByUsername(username);
        if (userDto != null) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("username", "이미 존재하는 사용자 이름입니다.");
            throw new CustomDuplicateUsernameException("Duplicate username!!!",errorMap);
        }
    }
//    public List<UserDto> getUsers() {
//        return userRepository.getUsers();
//    }
}
