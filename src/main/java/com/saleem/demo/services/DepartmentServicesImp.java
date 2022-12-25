package com.saleem.demo.services;

import com.saleem.demo.entity.Department;
import com.saleem.demo.error.DepartmentNotFoundException;
import com.saleem.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServicesImp implements DepartmentServices{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department=departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException(" No such department");

        }
        return department.get();
    }

    @Override
    public void deleteById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department department1=departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department .getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){

            department1.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){

            department1.setDepartmentCode(department.getDepartmentCode());
        }
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){

            department1.setDepartmentName(department.getDepartmentName());
        }
        return departmentRepository.save(department1);
    }

    @Override
    public List<Department> fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
