package com.cagatayhan.service;

import com.cagatayhan.model.Department;

/*
 * Created by Çağatay Han on 18.10.2016.
 */
public interface DepartmentService {
    Department[] getAllDepartments();
    Department getDepartmentById(int id);
    Department addDepartment(Department department);
    void deleteDepartment(int id);
}
