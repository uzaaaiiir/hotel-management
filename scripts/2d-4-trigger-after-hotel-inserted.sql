SET search_path='hotel_management';

CREATE FUNCTION update_no_of_hotels_on_insert()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE hotel_chain
    SET no_of_hotels = no_of_hotels + 1
    WHERE chain_id = NEW.chain_id;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_update_no_of_hotels_after_insert
AFTER INSERT ON hotel
FOR EACH ROW
EXECUTE FUNCTION update_no_of_hotels_on_insert();