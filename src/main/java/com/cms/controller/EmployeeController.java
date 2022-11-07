package com.cms.controller;

import com.cms.dto.EmployeeDTO;
import com.cms.entity.Employee;
import com.cms.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public @ResponseBody EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = mapper.map(employeeDTO, Employee.class);
        return mapper.map(employeeService.createEmployee(employee), EmployeeDTO.class);
    }
}
