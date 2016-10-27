package com.cagatayhan.service.Impl;

import com.cagatayhan.model.Department;
import com.cagatayhan.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Çağatay Han on 18.10.2016.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Department[] getAllDepartments() {
        final String url = "http://localhost:8000/departments/all";
        Department[] departments = restTemplate.getForObject(url, Department[].class);
        return departments;
    }

    @Override
    public Department getDepartmentById(int id) {
        final String url = "http://localhost:8000/departments/" + id;
        Department department = restTemplate.getForObject(url, Department.class);
        return department;
    }

    @Override
    public Department addDepartment(Department department) {
        final String url = "http://localhost:8000/departments/add";
        restTemplate.postForObject(url, department, Department.class);
        return department;
    }

    @Override
    public void deleteDepartment(int id) {
        final String url = "http://localhost:8000/departments/delete/" + id;
        restTemplate.delete(url, Department.class);
    }
}
