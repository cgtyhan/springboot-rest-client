package com.cagatayhan.controller;

import com.cagatayhan.model.Department;
import com.cagatayhan.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Çağatay Han on 20.10.2016.
 */
@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/departments")
    public String departments(ModelMap modelMap) {
        modelMap.addAttribute("departments", departmentService.getAllDepartments());

        return "departments";
    }

    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    public String addDepartment(@RequestParam String name) {
        Department department = new Department();
        department.setName(name);
        departmentService.addDepartment(department);

        return "redirect:/departments";
    }

    @RequestMapping(value = "/departments/delete/{id}")
    public String deleteDepartment(@PathVariable("id") int id) {
        departmentService.deleteDepartment(id);
        return "redirect:/departments";
    }
}
