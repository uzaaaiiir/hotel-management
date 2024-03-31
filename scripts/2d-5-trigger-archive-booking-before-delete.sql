SET search_path="hotel_management";

CREATE OR REPLACE FUNCTION archive_deleted_booking()
RETURNS TRIGGER AS $$
DECLARE
	room_snapshot JSON;
	customer_snapshot JSON;
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
	
	INSERT INTO booking_archive (
		booking_id,
		room_snapshot,
		customer_snapshot,
		start_date,
		end_date,
		archive_date
	) 
	VALUES (
		OLD.booking_id,
		room_snapshot,
		customer_snapshot,
		OLD.start_date,
		OLD.end_date,
		CURRENT_DATE
	);
	
	RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trigger_archive_booking_before_delete
BEFORE DELETE ON booking
FOR EACH ROW
EXECUTE FUNCTION archive_deleted_booking();