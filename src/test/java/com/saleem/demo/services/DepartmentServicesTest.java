package com.saleem.demo.services;

import com.saleem.demo.entity.Department;
import com.saleem.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServicesTest {
    @Autowired
    private DepartmentServices departmentServices;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department =Department.builder()
                .departmentName("it")
                .departmentCode("oo")
                .departmentAddress("madu")
                .departmentId(1L)
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("it")).thenReturn(department);

    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldBeFound( )  {

        String departmentName ="it";
        Department found= departmentServices.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }

}