package com.study.springboot202010kkr.web.controller;

import com.study.springboot202010kkr.service.EmployeeService;
import com.study.springboot202010kkr.web.dto.CMRespDto;
import com.study.springboot202010kkr.web.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/emp")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto) {

        return ResponseEntity.created(null).body(new CMRespDto<>("직원등록완료", employeeService.addEmployee(employeeDto)));
    }
}
