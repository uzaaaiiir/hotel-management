SET search_path="hotel_management";

CREATE VIEW hotel_room_capacity AS 
SELECT 
	h.hotel_id,
	hc.name,
	SUM(r.capacity) AS total_capacity
FROM hotel h
NATURAL JOIN hotel_chain hc
JOIN
	room r ON h.hotel_id = r.hotel_id
GROUP BY h.hotel_id, hc.name
ORDER BY h.hotel_id ASC;