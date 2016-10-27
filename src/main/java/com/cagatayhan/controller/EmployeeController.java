package com.cagatayhan.controller;

import com.cagatayhan.model.Employee;
import com.cagatayhan.service.DepartmentService;
import com.cagatayhan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
/**
 * Created by Çağatay Han on 16.10.2016.
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employees")
    public String employees(ModelMap modelMap) {
        modelMap.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    @RequestMapping("/employee/{id}")
    public String getEmployeeById(ModelMap modelMap, @PathVariable("id") int id) {
        modelMap.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employee";
    }

    @RequestMapping(value = "/employees/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}
