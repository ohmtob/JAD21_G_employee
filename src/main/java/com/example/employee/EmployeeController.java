package com.example.employee;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(path="/")
    @CrossOrigin()
    String empty()
    {
        return "OK!";
    }



    @GetMapping(path="/employees")
    @CrossOrigin()
    List<Employee> getAll(){
        return employeeService.getAll();
    }

    @GetMapping(path="/employee/{id}")
    @CrossOrigin()
    Employee getSingle(@PathVariable Integer id){
        return employeeService.getSingle(id);
    }



    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    @CrossOrigin()
    ResponseEntity<Object> add(@RequestBody Employee dbEmployee){

        employeeRepository.save(dbEmployee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path( "/{id}" )
                .buildAndExpand( dbEmployee.getId() )
                .toUri();
        return  ResponseEntity.created( location ).build();

    }

    @PutMapping(path = "/employee/{id}", consumes = "application/json", produces = "application/json")
    @CrossOrigin()
    Employee update(@PathVariable Integer id, @RequestBody Employee updateEmployee){
        Employee dbEmployee = employeeService.getSingle(id);
        dbEmployee.setName(updateEmployee.getName());
        dbEmployee.setSsn(updateEmployee.getSsn());
        dbEmployee.setHourlySalary(updateEmployee.getHourlySalary());
        dbEmployee.setCarReg(updateEmployee.getCarReg());
        employeeRepository.save(dbEmployee);
        return dbEmployee;
    }

    @DeleteMapping(path = "/delete/{id}")
    @CrossOrigin()
    public void delete(@PathVariable Integer id) {
        employeeRepository.deleteById(id);
    }
    
}
