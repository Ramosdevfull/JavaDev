package com.helloworld.demo.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.helloworld.demo.model.Address;
import com.helloworld.demo.model.Employee;

@Repository
@Transactional(readOnly = true)
public class EmployeeRepository {
    private final JdbcClient jdbcClient;

    public EmployeeRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Employee> findAll() {
        String sql = "SELECT * FROM employees";
        return jdbcClient.sql(sql).query(Employee.class).list();
    }

    public Optional<Employee> findById(long id) {
        String sql = "SELECT * FROM employees WHERE id = :id";
        return jdbcClient.sql(sql).param("id", id).query(Employee.class).optional();
    }

    @Transactional
    public Employee save(Employee e) {
        String sql = "INSERT INTO employees (nome, email, active, age, fk_adress_id) VALUES (:nome, :email, :active, :age, :fk_adress_id)";
        String sqlAddress = "SELECT * FROM addresses";
        List<Address> addresses =  jdbcClient.sql(sqlAddress).query(Address.class).list();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcClient.sql(sql)
            .param("name", e.getNome())
            .param("email", e.getEmail())
            .param("active", e.isActive())
            .param("age", e.getAge())
            .param("fk_address_id", e.getAddress())
            .update(keyHolder);

        BigInteger id = keyHolder.getKeyAs(BigInteger.class);
        e.setId(id.longValue());
        return e;
    }

    @Transactional
    public Employee update(Employee e) {
        String sql = "UPDATE employees SET nome = ?, email = ?, active = ?, age = ?";
        int count = jdbcClient.sql(sql)
            .param(1, e.getNome())
            .param(2, e.getEmail())
            .param(3, e.isActive())
            .param(4, e.getAge())
            .param(5, e.getAddress())
            .update();

        if (count == 0) {
            throw new RuntimeException("Employee not found!");
        }
        return e;
    }

    @Transactional
    public String deleteById(long id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        int count = jdbcClient.sql(sql).param(1, id).update();

        if (count == 0) {
            throw new RuntimeException("Employee not found!");
        }
        return "Employee deleted successfull!";
    }
}
