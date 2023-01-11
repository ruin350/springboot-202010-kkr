package com.study.springboot202010kkr.web.controller.account;

import com.study.springboot202010kkr.service.UserService;
import com.study.springboot202010kkr.web.dto.CMRespDto;
import com.study.springboot202010kkr.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
//@Validated
@RequestMapping("/api/account")
public class AccountApiController {

    @Autowired
    private UserService userService;
    // 중복확인.
    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(@Pattern(regexp = "^[a-zA-z\\d]{5,20}$",
            message = "사용자이름은 영문, 숫자 조합이어야하며<br> 5자 이상 20자 이하로작성하세요.") String username) {

        userService.duplicateUsername(username);
        return ResponseEntity.ok().body(new CMRespDto<>("가입가능한 사용자 이름", true));
    }

    // 회원가입.
    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        System.out.println(userDto);
        System.out.println(bindingResult.getFieldErrors());
        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });
            errorMap.forEach((k, v) -> {
                System.out.println(k + ": " + v);
            });
        }

        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }


}
