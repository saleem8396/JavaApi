package com.saleem.demo.repository;

import com.saleem.demo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
    void setUp() {
        Department department =Department.builder()
                .departmentName("mechanical")
                .departmentCode("008")
                .departmentAddress("madurai")
                .build();
        entityManager.persist(department);

    }

    @Test
    @DisplayName("find by id ")
    public void WhenFindById_ReturnAllId(){

        Department department=departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"mechanical");
    }
}