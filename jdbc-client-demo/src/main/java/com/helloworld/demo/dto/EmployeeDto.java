package com.helloworld.demo.dto;

import com.helloworld.demo.model.Address;

public class EmployeeDto {
    private Long id;
    private String nome;
    private Address address;
    private String email;
    private boolean active;
    private int age;
    
    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String nome, Address address, String email, boolean active, int age) {
        this.id = id;
        this.nome = nome;
        this.address = address;
        this.email = email;
        this.active = active;
        this.age = age;
    }
    

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return Address return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return boolean return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return int return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeDto [id=" + id + ", nome=" + nome + ", address=" + address + ", email=" + email + ", active="
                + active + ", age=" + age + "]";
    }

    
}
