package com.example.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String ssn;
    private int hourlySalary;
    private String carReg;


    public Integer calculateMonthlySalary(int hoursWorked)
    {
        return hoursWorked * hourlySalary;            
    }


    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }

    public String getSsn()
    {
        return ssn;
    }

    public void setSsn(String s)
    {
        ssn = s;
    }
  
    public void setHourlySalary(int hs)
    {
        hourlySalary  = hs;
    }

    public int getHourlySalary()
    {
        return hourlySalary;
    }

    public String getCarReg() {
        return carReg;
    }

    public void setCarReg(String cr) {
        this.carReg = cr;
    }

}
