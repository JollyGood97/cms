package com.cms.controller;

import com.cms.dto.EmployeeDTO;
import com.cms.entity.Employee;
import com.cms.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
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

    /**
     * Creates a new employee.
     *
     * @param employeeDTO The employeeDTO object
     * @return EmployeeDTO The newly created employeeDTO object
     */
    @PostMapping
    public @ResponseBody EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = mapper.map(employeeDTO, Employee.class);
        return mapper.map(employeeService.createEmployee(employee), EmployeeDTO.class);
    }

    /**
     * Get the entire list of employees. Has role restriction.
     *
     * @return EmployeeDTO List
     */
    @GetMapping
    @PreAuthorize("hasRole('HR_MANAGER') or hasRole('SUPER_ADMIN')")
    public @ResponseBody List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        return employees.stream().map(employee ->
                mapper.map(employee, EmployeeDTO.class)
        ).collect(Collectors.toList());
    }

    /**
     * Find an employee by its id.
     *
     * @param employeeId The id of the employee
     * @return EmployeeDTO The found employeeDTO object
     */
    @GetMapping("/{employeeId}")
    public @ResponseBody EmployeeDTO getEmployeeById(@PathVariable String employeeId) {
        return mapper.map(employeeService.getEmployeeById(employeeId), EmployeeDTO.class);
    }

    /**
     * Updates an employee.
     *
     * @param employeeId The id of the employee to be updated.
     * @return EmployeeDTO The edited employeeDTO object
     */
    @PutMapping("/{employeeId}")
    public @ResponseBody EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable String employeeId) {
        Employee employee = mapper.map(employeeDTO, Employee.class);
        return mapper.map(employeeService.updateEmployee(employeeId, employee), EmployeeDTO.class);

    }

    /**
     * Delete an employee.
     *
     * @param employeeId The id of the employee to be deleted
     */
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    /**
     * Get the list of employees belonging to the particular Engineering Cooperation.
     *
     * @param corpId The id of the Engineering Cooperation.
     */
    @GetMapping("/corps/{corpId}")
    public @ResponseBody List<EmployeeDTO> getEmployeesByCompany(@PathVariable String corpId) {
        List<Employee> employees = employeeService.getEmployeesByCompany(corpId);
        return employees.stream().map(employee ->
                mapper.map(employee, EmployeeDTO.class)
        ).collect(Collectors.toList());
    }
}
