package com.saleem.demo.controller;

import com.saleem.demo.entity.Department;
import com.saleem.demo.error.DepartmentNotFoundException;
import com.saleem.demo.services.DepartmentServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentServices departmentServices;

    @PostMapping("/departments")
    public Department save(@Valid @RequestBody Department department){
        return departmentServices.saveDepartment(department);
    }
    @GetMapping("/getdepartments")
    public List<Department> getlist(){
        return departmentServices.getList();
    }

    @GetMapping("/id={id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

        return departmentServices.getDepartmentById(departmentId);
    }
    @DeleteMapping("/id={id}")
    public String deleteById(@PathVariable("id") Long departmentId){

        departmentServices.deleteById(departmentId);
        return "Department deleted successfully";
    }
    @PutMapping("/id={id}")
    public Department updateDepartment( @PathVariable("id") Long departmentId ,@RequestBody Department department){

        return departmentServices.updateDepartment(departmentId,department);
    }
    @GetMapping("/departmentName={name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) throws DepartmentNotFoundException {
       return departmentServices.fetchDepartmentByName(departmentName);
    }
}
