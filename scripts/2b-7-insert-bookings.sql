set search_path="hotel_management";

INSERT INTO booking (room_id, customer_id, start_date, end_date, room_status, payment_status)
VALUES
	(1, 1, '2024-03-24', '2024-03-31', 'Booked', 'Paid'),
	(1, 3, '2024-03-14', '2024-03-23', 'Booked', 'Paid'),
	(2, 1, '2024-03-24', CURRENT_DATE, 'Booked', 'Paid'),
	(7, 2, '2024-03-24', CURRENT_DATE, 'Cancelled', 'Cancelled');