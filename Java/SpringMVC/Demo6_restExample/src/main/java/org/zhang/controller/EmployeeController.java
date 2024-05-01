package org.zhang.controller;

/**
 * @author: zhanghao
 * @date: 2022/1/20-12:53
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zhang.bean.Employee;
import org.zhang.dao.EmployeeDao;

import java.util.Collection;

/**
 * @Description
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String getAllEmployee(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employeeList", employees);
        return "employee_list";
    }


    //删除
    @RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Integer id) {
            employeeDao.delete(id);
            return "redirect:/employee";
    }

    //根据id查询
    @GetMapping(value = "/employee/{id}")
    public String getEmployeeById(@PathVariable(value = "id") Integer id,Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "edit";
    }

    //更新
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    //添加
    @PostMapping("/employee")
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

}
