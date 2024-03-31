package com.project.hotel.repository;

import com.project.hotel.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RoomRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RoomRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Room> findAvailableRooms(String startDate, String endDate, Integer capacity, String city, String chainName, Integer rating, Double maxPrice) {
        if (startDate.isEmpty()) {
            startDate = null;
        }

        if (endDate.isEmpty()) {
            endDate = null;
        }

        if (city.isEmpty()) {
            city = null;
        }

        if (chainName.isEmpty()) {
            chainName = null;
        }

        String sql = "SELECT r.*, hc.name, h.city FROM room r " +
                "JOIN hotel h ON r.hotel_id = h.hotel_id " +
                "NATURAL JOIN hotel_chain hc " +
                "WHERE NOT EXISTS (SELECT 1 FROM booking b WHERE b.room_id = r.room_id AND b.end_date >= ?::date AND b.start_date <= ?::date) " +
                "AND (?::integer IS NULL OR r.capacity >= ?::integer) " +
                "AND (?::varchar IS NULL OR h.city = ?::varchar) " +
                "AND (?::varchar IS NULL OR hc.name = ?::varchar) " +
                "AND (?::integer IS NULL OR h.rating >= ?::integer) " +
                "AND (?::decimal IS NULL OR r.price <= ?::decimal)";

        List<Room> rooms = jdbcTemplate.query(sql, new Object[]{startDate, endDate, capacity, capacity, city, city, chainName, chainName, rating, rating, maxPrice, maxPrice}, new BeanPropertyRowMapper<>(Room.class));

        for (Room room : rooms) {
            System.out.println(room);
        }

        return rooms;
    }

    public List<Room> viewAllRooms() {
        String sql = "SELECT * FROM room";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Room.class));
    }

    public List<Room> findByHotelId(Long id) {
        String sql = "SELECT * FROM room WHERE hotel_id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Room.class));
    }
}
