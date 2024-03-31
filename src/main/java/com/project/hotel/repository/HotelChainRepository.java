package com.project.hotel.repository;

import com.project.hotel.model.Customer;
import com.project.hotel.model.HotelChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelChainRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<HotelChain> findAll() {
        String sql = "SELECT * FROM hotel_chain";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(HotelChain.class));
    }

    public HotelChain findById(Long id) {
        String sql = "SELECT * FROM hotel_chain WHERE chain_id = ?";
        List<HotelChain> hotels = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(HotelChain.class));
        return hotels.get(0);
    }

    public int addHotelChain(HotelChain hotelChain) {
        String sql = "INSERT INTO hotel_chain " +
                "(name, no_of_hotels) " +
                "VALUES (?, ?)";
        return jdbcTemplate.update(sql, hotelChain.getName(), 0);
    }

    public void deleteHotelChain(Long id) {
        String sql = "DELETE FROM hotel_chain WHERE chain_id = ?::integer";
        jdbcTemplate.update(sql, id);
    }
}
