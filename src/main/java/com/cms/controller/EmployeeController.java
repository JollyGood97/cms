package com.cms.controller;

import com.cms.dto.EmployeeDTO;
import com.cms.entity.Employee;
import com.cms.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public @ResponseBody List<EmployeeDTO> getAllEmployees(){
        List<Employee> employees = employeeService.getEmployees();
        return employees.stream().map(employee ->
            mapper.map(employee, EmployeeDTO.class)
        ).collect(Collectors.toList());
    }

    @GetMapping("/{employeeId}")
    public @ResponseBody EmployeeDTO getEmployeeById(@PathVariable String employeeId){
        return mapper.map(employeeService.getEmployeeById(employeeId), EmployeeDTO.class);
    }

    @PutMapping("/{employeeId}")
    public @ResponseBody EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable String employeeId) {
        Employee employee = mapper.map(employeeDTO, Employee.class);
        return mapper.map(employeeService.updateEmployee(employeeId, employee), EmployeeDTO.class);

    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}
