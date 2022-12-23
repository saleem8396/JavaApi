package com.saleem.demo.services;

import com.saleem.demo.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentServices {
    public Department saveDepartment(Department department);

    public List<Department> getlist();
}
