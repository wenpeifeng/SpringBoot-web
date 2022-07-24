package com.Controller;

import com.Dao.DepartmentDao;
import com.Dao.EmployeeDao;
import com.POJO.Department;
import com.POJO.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    // 不加@Autowired注解会报错，无法获取到bean
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    // 员工列表页面
    @RequestMapping("/emps/getEmpList.do")
    public String empList(Model model){
        Collection<Employee> employeeList = employeeDao.getEmployeeList();
        model.addAttribute("empList",employeeList);
        return "emp/empList"; // 跳转至人员页面
    }

    // 添加员工页面
    @GetMapping("/emps/addEmp.do")
    public String toToAddEmpPage(Model model){
        // 查出部门信息返回到前端
        Collection<Department> departmentList = departmentDao.getDepartmentList();
        model.addAttribute("departmentList",departmentList);
        return "emp/addEmp"; // 跳转至添加人员页面
    }

    // 添加员工submit（不同的请求Get/Post方式，可以定义一样的请求路径/emps/addEmp.do）
    @PostMapping("/emps/addEmp.do")
    public String addEmpSubmit(Employee employee){
        // 保存员工信息
        employeeDao.save(employee);
        System.out.println("save=>"+employee);
        return "redirect:/emps/getEmpList.do"; // 重定向员工列表页面请求方法
    }


    // 修改员工页面
    @GetMapping("/emps/editEmp.do/{id}")
    public String toToEditEmpPage(@PathVariable("id")Integer id, Model model){
        // 查出员工信息
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee",employee);
        // 查出部门信息返回到前端
        Collection<Department> departmentList = departmentDao.getDepartmentList();
        model.addAttribute("departmentList",departmentList);
        return "emp/editEmp"; // 跳转至编辑人员页面
    }

    // 修改员工submit（不同的请求Get/Post方式，可以定义一样的请求路径/emps/addEmp.do）
    @PostMapping("/emps/editEmp.do")
    public String editEmpSubmit(Employee employee){
        // 保存员工信息
        employeeDao.save(employee);
        System.out.println("save=>"+employee);
        return "redirect:/emps/getEmpList.do"; // 重定向员工列表页面请求方法
    }


    // 删除员工
    @GetMapping("/emps/delEmp.do/{id}")
    public String delEmpSubmit(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps/getEmpList.do"; // 重定向员工列表页面请求方法
    }
}
