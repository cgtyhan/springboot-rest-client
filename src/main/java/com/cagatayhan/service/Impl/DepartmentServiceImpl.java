package com.cagatayhan.service.Impl;

import com.cagatayhan.model.Department;
import com.cagatayhan.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
 * Created by Çağatay Han on 18.10.2016.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final String url = "http://localhost:8000/departments";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Department[] getAllDepartments() {
        return restTemplate.getForObject(url + "/all", Department[].class);
    }

    @Override
    public Department getDepartmentById(int id) {
        return restTemplate.getForObject(url + "/" + id, Department.class);
    }

    @Override
    public Department addDepartment(Department department) {
        restTemplate.postForObject(url + "/add", department, Department.class);
        return department;
    }

    @Override
    public void deleteDepartment(int id) {
        restTemplate.delete(url + "/delete/" + id, Department.class);
    }
}
