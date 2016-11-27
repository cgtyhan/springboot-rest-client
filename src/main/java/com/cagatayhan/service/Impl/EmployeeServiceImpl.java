package com.cagatayhan.service.Impl;

import com.cagatayhan.model.Employee;
import com.cagatayhan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
 * Created by Çağatay Han on 17.10.2016.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final String url = "http://localhost:8000/employees";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Employee[] getAllEmployees() {
        return restTemplate.getForObject(url + "/all", Employee[].class);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return restTemplate.getForObject(url + "/" + id, Employee.class);
    }

    @Override
    public void deleteEmployeeById(int id) {
        restTemplate.delete(url + "/delete/" + id, Employee.class);
    }
}
