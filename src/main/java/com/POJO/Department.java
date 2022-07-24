package com.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  // 有参构造
@NoArgsConstructor   // 无参数构造
public class Department {
    private Integer id;
    private String departName;
}
