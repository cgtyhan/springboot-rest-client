package com.cagatayhan.controller;

import com.cagatayhan.model.Department;
import com.cagatayhan.model.Manager;
import com.cagatayhan.service.DepartmentService;
import com.cagatayhan.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Çağatay Han on 21.10.2016.
 */
@Controller
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/managers")
    public String getAllManagers(ModelMap modelMap) {
        modelMap.addAttribute("managers", managerService.getAllManagers());
        modelMap.addAttribute("departments", departmentService.getAllDepartments());

        return "managers";
    }

    @RequestMapping(value = "/manager/{id}")
    public String getManagerById(ModelMap modelMap, @PathVariable("id") int id) {
        modelMap.addAttribute("manager", managerService.getManagerById(id));

        return "manager";
    }

    @RequestMapping(value = "/managers", method = RequestMethod.POST)
    public String addManager(@RequestParam String name,
                             @RequestParam String address,
                             @RequestParam int departmentId,
                             @RequestParam int salary,
                             Manager manager) {
        Department department = departmentService.getDepartmentById(departmentId);
        manager.setName(name);
        manager.setAddress(address);
        manager.setSalary(salary);
        manager.setDepartment(department);
        managerService.addManager(manager);

        return "redirect:/managers";
    }
}
