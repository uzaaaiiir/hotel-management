set search_path="hotel_management";

-- Find all 5 star hotels in Ottawa and the manager name
SELECT hotel.hotel_id, hotel_chain.name, hotel.rating, hotel.city, employee.first_name as mngr_first_name
FROM hotel 
NATURAL JOIN hotel_chain
JOIN employee
ON hotel.hotel_id = employee.hotel_id and employee.is_manager = true
WHERE hotel.rating = 5 and hotel.city = 'Ottawa';