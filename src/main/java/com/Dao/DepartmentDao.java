package com.Dao;

import com.POJO.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// @Repository 用在持久层上，表示创建dao对象，dao对象是能访问数据库的
@Repository
public class DepartmentDao {

    private static Map<Integer,Department> departMap=null;

    // 模拟数据库
    static {
        departMap = new HashMap<>();
        departMap.put(1001,new Department(1001,"技术部"));
        departMap.put(1002,new Department(1002,"后勤部"));
        departMap.put(1003,new Department(1003,"运营部"));
        departMap.put(1004,new Department(1004,"财务部"));
    }

    // 获取所有部门信息
    public Collection<Department> getDepartmentList(){
        return departMap.values();
    }

    // 通过id获取部门信息
    public Department getDepartmentById(Integer id){
        return departMap.get(id);
    }
}
