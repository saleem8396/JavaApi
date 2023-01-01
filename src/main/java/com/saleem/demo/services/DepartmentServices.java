package com.saleem.demo.services;

import com.saleem.demo.entity.Department;
import com.saleem.demo.error.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentServices {
    public Department saveDepartment(Department department);

    public List<Department> getList();

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

   public void deleteById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

   public Department fetchDepartmentByName(String departmentName) throws DepartmentNotFoundException;
}
