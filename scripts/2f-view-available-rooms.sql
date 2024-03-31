SET search_path="hotel_management";

CREATE VIEW available_rooms_per_area AS
SELECT 
	h.city,
	COUNT(r.room_id) AS available_rooms
FROM hotel h
JOIN 
    room r ON h.hotel_id = r.hotel_id
LEFT JOIN 
	booking b ON r.room_id = b.room_id AND CURRENT_DATE BETWEEN b.start_date and b.end_date
LEFT JOIN
	renting rt ON r.room_id = rt.room_id AND CURRENT_DATE BETWEEN rt.start_date and rt.end_date
WHERE b.booking_id IS NULL and rt.renting_id IS NULL
GROUP BY h.city;
