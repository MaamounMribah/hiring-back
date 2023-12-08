package com.example.demo2.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class EmployeeDTO {
    private int employeeid;
    private String employeename;
    private String email;
    private String password;
    public EmployeeDTO() {
    }
    public EmployeeDTO(int employeeid, String employeename, String email, String password) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.email = email;
        this.password = password;
    }
}