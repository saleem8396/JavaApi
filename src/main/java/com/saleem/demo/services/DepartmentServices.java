package com.saleem.demo.services;

import com.saleem.demo.entity.Department;
import org.springframework.stereotype.Service;


public interface DepartmentServices {
    public Department saveDepartment(Department department);
}
