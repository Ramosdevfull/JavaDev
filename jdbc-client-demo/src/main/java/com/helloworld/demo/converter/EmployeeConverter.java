package com.helloworld.demo.converter;

import com.helloworld.demo.dto.EmployeeDto;
import com.helloworld.demo.model.Address;
import com.helloworld.demo.model.Employee;

public class EmployeeConverter {
    public static Employee mapToEmployee(EmployeeDto empDto) {
        Employee e = new Employee(
                        empDto.getId()
                        , empDto.getNome()
                        , empDto.getEmail()
                        , empDto.isActive()
                        , empDto.getAddress()
                        , empDto.getAge());
                    return e;
    }

     private Long id;
    private String nome;
    private Address address;
    private String email;
    private boolean active;
    private int age;
}
