set search_path="hotel_management";

SELECT hc.name AS hotel_name, lb.*
FROM hotel_chain hc
NATURAL JOIN hotel h
JOIN (
    SELECT b.booking_id, b.room_id, b.customer_id, b.start_date, b.end_date, b.room_status, b.payment_status, r.hotel_id
    FROM booking b
    JOIN room r ON b.room_id = r.room_id
    WHERE 
        b.end_date = (
            SELECT MAX(b2.end_date) 
            FROM booking b2 
            JOIN room r2 ON b2.room_id = r2.room_id
            WHERE r2.hotel_id = r.hotel_id
        )
) AS lb ON h.hotel_id = lb.hotel_id;

