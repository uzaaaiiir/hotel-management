SET search_path="hotel_management";

-- Indexes

-- Index for Hotel Chain name
CREATE INDEX hotel_chain_name_index ON hotel_chain(name);

-- Index for Hotel city and rating
CREATE INDEX hotel_city_rating_index ON hotel(city, rating);

-- Index for Booking start date and end date
CREATE INDEX booking_dates_index ON booking(start_date, end_date);