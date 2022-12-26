package com.saleem.demo.repository;

import com.saleem.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
