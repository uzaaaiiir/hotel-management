SET search_path="hotel_management";

CREATE FUNCTION archive_deleted_renting()
RETURNS TRIGGER AS $$
DECLARE
	room_snapshot JSON;
	customer_snapshot JSON;
	employee_snapshot JSON;
BEGIN
	SELECT json_build_object(
		'room_id', r.room_id,
		'hotel_id', r.hotel_id,
		'room_number', r.room_number,
		'price', r.price,
		'amenities', r.amenities
		'capacity', r.capacity,
		'view', r.view,
		'is_extendable', r.is_extendable,
		'problems_and_damages', r.problems_and_damages
	) INTO room_snapshot
	FROM room r
	WHERE r.room_id = OLD.room_id;
	
	SELECT json_build_object(
		'customer_id', c.customer_id,
		'id_number', c.id_number,
		'first_name', c.first_name,
		'last_name', c.last_name,
		'type_of_id', c.type_of_id,
		'registration_date', c.registration_date
	) INTO customer_snapshot
	FROM customer c
	WHERE c.customer_id = OLD.customer_id;
	
	SELECT json_build_object(
		'employee_id', e.employee_id,
		'hotel_id', e.hotel_id,
		'position_id', e.position_id,
		'first_name', e.first_name,
		'last_name', e.last_name,
		'address', e.address,
		'ssn_or_sin_no', e.ssn_or_sin_no,
		'is_manager', e.is_manager
	) INTO employee_snapshot
	FROM employee e
	WHERE e.employee_id = OLD.employee_id;
	
	INSERT INTO renting_archive (
		renting_id,
		room_snapshot,
		customer_snapshot,
		employee_snapshot,
		start_date,
		end_date,
		archive_date
	) 
	VALUES (
		OLD.booking_id,
		room_snapshot,
		customer_snapshot,
		employee_snapshot,
		OLD.start_date,
		OLD.end_date,
		CURRENT_DATE
	);
	
	RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_archive_renting_before_delete
BEFORE DELETE ON renting
FOR EACH ROW
EXECUTE FUNCTION archive_deleted_renting();