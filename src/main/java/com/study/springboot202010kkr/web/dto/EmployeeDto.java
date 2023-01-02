package com.study.springboot202010kkr.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private int empId;
    private String empName;
    private int empAge;
    private String empPhone;
}
