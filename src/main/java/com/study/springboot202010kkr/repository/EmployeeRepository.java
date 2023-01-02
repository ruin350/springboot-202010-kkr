package com.study.springboot202010kkr.repository;

import com.study.springboot202010kkr.web.dto.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {
    public int saveEmployee(EmployeeDto employeeDto);

}
