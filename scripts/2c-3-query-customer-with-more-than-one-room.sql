set search_path="hotel_management";

SELECT customer.customer_id, customer.first_name, customer.last_name, COUNT(booking.booking_id) as bookings_count
FROM customer
JOIN booking ON customer.customer_id = booking.customer_id
GROUP BY customer.customer_id
HAVING COUNT(booking.booking_id) > 1;