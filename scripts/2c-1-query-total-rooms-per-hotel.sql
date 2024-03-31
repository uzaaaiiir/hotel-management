set search_path="hotel_management";

-- Count number of rooms per hotel
SELECT hotel.hotel_id, COUNT(room.room_id) as total_rooms
FROM hotel
NATURAL JOIN room
GROUP BY hotel.hotel_id
ORDER BY total_rooms DESC;