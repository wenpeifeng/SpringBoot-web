package com.Dao;

import com.POJO.Department;
import com.POJO.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// @Repository 用在持久层上，表示创建dao对象，dao对象是能访问数据库的
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> empMap;

    // 引用类型的属性赋值  注入此dao
    @Autowired
    private DepartmentDao departmentDao;

    // 模拟数据库
    static {
        empMap = new HashMap<>();
        empMap.put(101,new Employee(101,"张三","A1214@qq.com",new Department(1001,"技术部"),0));
        empMap.put(102,new Employee(102,"李四","B1214@qq.com",new Department(1002,"后勤部"),1));
        empMap.put(103,new Employee(103,"王五","V1214@qq.com",new Department(1003,"运营部"),1));
    }

    // 模拟主键自增
    private static Integer initId=104;

    // 添加一个员工
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        empMap.put(employee.getId(),employee);
    }

    // 获取所有人员信息
    public Collection<Employee> getEmployeeList(){
        return empMap.values();
    }

    // 通过id获取人员信息
    public Employee getEmployeeById(Integer id){
        return empMap.get(id);
    }

    // 通过id 删除员工
    public void delete(Integer id){
        empMap.remove(id);
    }
}
