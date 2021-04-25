package com.example.employee;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.context.TestExecutionListener;

public class EmployeeServiceTests {
    
    EmployeeRepository employeeRepository;
    ArrayList<Employee> testlist;
    @BeforeEach
    void init()
    {
        testlist = new ArrayList<Employee>();
        testlist.add(new Employee());
        testlist.add(new Employee());
        testlist.add(new Employee());
        testlist.add(new Employee());
        testlist.add(new Employee());
        testlist.add(new Employee());
        employeeRepository = Mockito.mock(EmployeeRepository.class); 
        when(employeeRepository.findAll()).thenReturn(testlist);
    }

    @Test
    void getAllReturnsAllRecords()
    {
        var sut = new EmployeeService(employeeRepository);
        assertArrayEquals( testlist.toArray() ,sut.getAll().toArray());            
    }


}
