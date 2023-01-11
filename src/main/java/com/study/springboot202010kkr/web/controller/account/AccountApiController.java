package com.study.springboot202010kkr.web.controller.account;

import com.study.springboot202010kkr.service.UserService;
import com.study.springboot202010kkr.web.Exception.CustomValidException;
import com.study.springboot202010kkr.web.dto.CMRespDto;
import com.study.springboot202010kkr.web.dto.UserDto;
import com.study.springboot202010kkr.web.dto.UsernameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    @Autowired
    private UserService userService;
    // 중복확인.
    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(@Valid UsernameDto usernameDto, BindingResult bindingResult) {
        userService.duplicateUsername(usernameDto.getUsername());
        return ResponseEntity.ok().body(new CMRespDto<>("가입가능한 사용자 이름", true));
    }

    // 회원가입.
    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }


}
