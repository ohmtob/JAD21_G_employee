package com.example.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    List<Employee> getAll(){
        var l = new ArrayList<Employee>();
        for(Employee r : employeeRepository.findAll())
        {
            l.add(r);
        }
        return l;
    }

    Employee getSingle(Integer id){
        return employeeRepository.findById(id).get();
    }

}
