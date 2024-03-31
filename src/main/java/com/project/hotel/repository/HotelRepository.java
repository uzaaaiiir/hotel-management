package com.project.hotel.repository;

import com.project.hotel.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Hotel> findAll() {
        String sql = "SELECT h.*, hc.name FROM hotel h " +
                "JOIN hotel_chain hc ON h.chain_id = hc.chain_id";
        List<Hotel> hotels =  jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Hotel.class));

        for (Hotel hotel : hotels) {
            System.out.println(hotel);
        }

        return hotels;
    }

    public List<Hotel> findByChainId(Long chainId) {
        String sql = "SELECT * FROM hotel WHERE chain_id = ?::integer";
        return jdbcTemplate.query(sql, new Object[]{chainId}, new BeanPropertyRowMapper<>(Hotel.class));
    }

    public Hotel findById(Long id) {
        String sql = "SELECT * FROM hotel WHERE hotel_id = ?::integer";
        List<Hotel> hotels = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Hotel.class));
        return hotels.get(0);
    }

    public int addHotel(Hotel hotel) {
        String sql = "INSERT INTO hotel " +
                "(chain_id, address, city, email_address, no_of_rooms, rating) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, hotel.getChainId(), hotel.getAddress(),
                hotel.getCity(), hotel.getEmailAddress(), 0, hotel.getRating());
    }

    public int updateHotel(Hotel hotel) {
        String sql = "UPDATE hotel " +
                "SET address = ?::varchar, city = ?::varchar, email_address = ?::varchar, rating = ?::integer " +
                "WHERE hotel_id = ?::integer";
        return jdbcTemplate.update(sql, hotel.getAddress(), hotel.getCity(), hotel.getEmailAddress(), hotel.getRating(), hotel.getHotelId());
    }

    public void deleteHotel(Long id) {
        jdbcTemplate.update("DELETE FROM hotel WHERE hotel_id = ?", id);
    }
}
