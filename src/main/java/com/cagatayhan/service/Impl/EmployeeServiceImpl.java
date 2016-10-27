package com.cagatayhan.service.Impl;

import com.cagatayhan.model.Employee;
import com.cagatayhan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Çağatay Han on 17.10.2016.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Employee[] getAllEmployees() {
        final String url = "http://localhost:8000/employees/all";
        Employee[] employees = restTemplate.getForObject(url, Employee[].class);
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        final String url = "http://localhost:8000/employees/" + id;
        Employee employee = restTemplate.getForObject(url, Employee.class);
        return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        final String url = "http://localhost:8000/employees/add";
        restTemplate.postForObject(url, employee, Employee.class);
        return employee;
    }

    @Override
    public void deleteEmployeeById(int id) {
        final String url = "http://localhost:8000/employees/delete/" + id;
        restTemplate.delete(url, Employee.class);
    }
}
