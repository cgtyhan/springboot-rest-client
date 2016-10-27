package com.cagatayhan.model;

/**
 * Created by Çağatay Han on 21.10.2016.
 */
public class Manager extends Employee {
    private int salary;
    private Department department;

    public Manager() {
        super();
    }

    public Manager(int id, String name, String address, int salary, Department department) {
        super(id, name, address);
        this.salary = salary;
        this.department = department;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public Department getDepartment() {
        return department;
    }

    @Override
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "salary=" + salary +
                ", department=" + department +
                '}';
    }
}
