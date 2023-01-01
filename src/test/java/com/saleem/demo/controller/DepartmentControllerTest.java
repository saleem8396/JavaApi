package com.saleem.demo.controller;

import com.saleem.demo.entity.Department;
import com.saleem.demo.error.DepartmentNotFoundException;
import com.saleem.demo.services.DepartmentServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class DepartmentControllerTest {

    @MockBean
    private DepartmentServices departmentServices;
    @Autowired
    private MockMvc mockMvc;

    private Department department;
    @BeforeEach
    void setUp() {
    department =Department.builder()
                .departmentId(1L)
                .departmentName("mechanical")
                .departmentCode("008")
                .departmentAddress("madurai")
                .build();


    }


    @Test
    void save() throws Exception {
        Department inputDepartment =Department.builder()
                .departmentName("mechanical")
                .departmentCode("008")
                .departmentAddress("madurai")
                .build();

        Mockito.when(departmentServices.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "    \"departmentName\":\"mechanical\",\n" +
                "    \"departmentAddress\":\"madurai\",\n" +
                "    \"departmentCode\":\"008\"\n" +
                "   \n" +
                "}")).andExpect(status().isOk());

    }

    @Test
    @DisplayName("fecting data using departmentName")
    void fetchDepartmentByName() throws Exception , DepartmentNotFoundException {
//        Department inputDepartment =Department.builder()
//                .departmentName("mechanical")
//                .departmentCode("008")
//                .departmentAddress("madurai")
//                .build();

        Mockito.when(departmentServices.fetchDepartmentByName("mechanical"))
                .thenReturn(department);

        mockMvc.perform(get("/departmentName=mechanical").contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.departmentName")
                                .value(department.getDepartmentName()));

    }
}