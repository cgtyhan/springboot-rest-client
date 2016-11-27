package com.cagatayhan.service;

import com.cagatayhan.model.Employee;

/*
 * Created by Çağatay Han on 17.10.2016.
 */
public interface EmployeeService {
    Employee[] getAllEmployees();
    Employee getEmployeeById(int id);
    void deleteEmployeeById(int id);
}
