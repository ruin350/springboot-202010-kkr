package com.study.springboot202010kkr.web.controller;

import com.study.springboot202010kkr.web.Exception.CustomTestException;
import com.study.springboot202010kkr.web.dto.CMRespDto;
import com.study.springboot202010kkr.web.dto.UserDto;
import com.sun.net.httpserver.Headers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestController1 {
    @GetMapping("/api/test/user-dto/str")
    public String getUserDtoStr() {
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        return userDto.toString();
    }
    @GetMapping("/api/test/user-dto/obj")
    public ResponseEntity<?> getUserDtoObj() {
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("UserDto", userDto.toString());
//        return new ResponseEntity<>(headers, HttpStatus.OK);
        return ResponseEntity.ok().headers(headers).body(userDto);
//        return new ResponseEntity<UserDto>(userDto, HttpStatus.INTERNAL_SERVER_ERROR);
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userDto);
    }

    @GetMapping("/api/test/user-dto/cm")
    public ResponseEntity<?> getUserDto(){
        UserDto userDto = UserDto.builder()
                .username("test")
                .password("1234")
                .build();
        return ResponseEntity.ok().body(new CMRespDto<>("test유저 정보 응답", null));
    }
//    예외처리
    @PostMapping("/api/test/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        if(userDto.getUsername().isBlank()) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("username", "아이디를 입력하세요");

            throw new CustomTestException("유효성 검사 실패", errorMap);
        }
        if(userDto.getPassword().isBlank()) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("password", "암호를 입력하세요");

            throw new CustomTestException("유효성 검사실패", errorMap);
        }
        userDto.setUserId(200);
        return ResponseEntity.created(null)
                .body(new CMRespDto<>(userDto.getUserId() + "사용자 추가 성공!", userDto));
    }
}
