package com.cagatayhan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Created by Çağatay Han on 16.10.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Department {
    private int id;
    private String name;

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
