package com.example.demo2.service;

import com.example.demo2.dto.EmployeeDTO;
import com.example.demo2.dto.LoginDTO;
import com.example.demo2.model.LoginMesage;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);
    LoginMesage loginEmployee(LoginDTO loginDTO);
}