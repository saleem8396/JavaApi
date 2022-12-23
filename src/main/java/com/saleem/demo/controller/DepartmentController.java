package com.saleem.demo.controller;

import com.saleem.demo.entity.Department;
import com.saleem.demo.services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentServices departmentServices;

    @PostMapping("/departments")
    public Department save(@RequestBody Department department){
        return departmentServices.saveDepartment(department);
    }
    @GetMapping("/getdepartments")
    public List<Department> getlist(){
        return departmentServices.getlist();
    }

}
