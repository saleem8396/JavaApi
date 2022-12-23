package com.saleem.demo.controller;

import com.saleem.demo.entity.Department;
import com.saleem.demo.services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentServices departmentServices;

    @PostMapping("/departments")
    public Department save(@RequestBody Department department){
        return departmentServices.saveDepartment(department);
    }

}
