SET search_path="hotel_management";

CREATE FUNCTION update_no_of_rooms_on_delete()
RETURNS TRIGGER AS $$
BEGIN
	UPDATE hotel
	SET no_of_rooms = no_of_rooms - 1
	WHERE hotel_id = OLD.hotel_id;
	RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_update_no_of_rooms_after_delete
AFTER DELETE ON room
FOR EACH ROW
EXECUTE FUNCTION update_no_of_rooms_on_delete();