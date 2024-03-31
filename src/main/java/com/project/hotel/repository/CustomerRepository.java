package com.project.hotel.repository;

import com.project.hotel.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }

    public Customer findById(Long id) {
        String sql = "SELECT * FROM customer where customer_id = ?::integer";
        List<Customer> customers = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Customer.class));

        return customers.get(0);
    }

    public int addCustomer(Customer customer) {
        String sql = "INSERT INTO customer " +
                "(id_number, first_name, last_name, type_of_id) " +
                "VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, customer.getIdNumber(), customer.getFirstName(), customer.getLastName(), customer.getTypeOfId());
    }

    public int updateCustomer(Customer customer) {
        String sql = "UPDATE customer " +
                "SET id_number = ?::varchar, first_name = ?::varchar, last_name = ?::varchar, type_of_id = ?::varchar " +
                "WHERE id_number = ?::varchar";
        return jdbcTemplate.update(sql, customer.getIdNumber(), customer.getFirstName(), customer.getLastName(), customer.getTypeOfId(), customer.getIdNumber());
    }

    public void deleteCustomer(Long id) {
        jdbcTemplate.update("DELETE FROM customer WHERE customer_id = ?", id);
    }
}
