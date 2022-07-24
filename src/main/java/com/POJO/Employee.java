package com.POJO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Department department;
    private Integer gender;  // 0.女  1.男
    private Date birth;

    public Employee(Integer id, String name, String email, Department department, Integer gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.gender = gender;
        this.birth = new Date();
    }
}
