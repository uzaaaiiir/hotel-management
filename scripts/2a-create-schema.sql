CREATE SCHEMA IF NOT EXISTS hotel_management
	AUTHORIZATION postgres;
	
set search_path="hotel_management";

CREATE TABLE hotel_chain (
	chain_id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	no_of_hotels INT CHECK (no_of_hotels >= 0)
);

CREATE TABLE central_office (
	central_office_id SERIAL PRIMARY KEY,
	chain_id INT NOT NULL,
	address VARCHAR(255) NOT NULL,
	email_address VARCHAR(255) UNIQUE NOT NULL,
	phone_number VARCHAR(30) NOT NULL,
	FOREIGN KEY (chain_id) REFERENCES hotel_chain(chain_id)
		ON DELETE CASCADE 
		ON UPDATE CASCADE
);

CREATE TABLE hotel (
	hotel_id SERIAL PRIMARY KEY,
	chain_id INT NOT NULL,
	address VARCHAR(255) NOT NULL,
	city VARCHAR(50),
	email_address VARCHAR(255) UNIQUE NOT NULL,
	no_of_rooms INT CHECK (no_of_rooms >= 0),
	rating INT CHECK (rating BETWEEN 1 AND 5),
	FOREIGN KEY (chain_id) REFERENCES hotel_chain(chain_id)
		ON DELETE RESTRICT 
		ON UPDATE RESTRICT
);

CREATE TABLE phone_number(
	phone_number_id SERIAL PRIMARY KEY,
	hotel_id INT NOT NULL,
	phone_number VARCHAR(20) NOT NULL,
	FOREIGN KEY (hotel_id) REFERENCES hotel(hotel_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	UNIQUE (hotel_id, phone_number)
);

CREATE TABLE position (
	position_id SERIAL PRIMARY KEY,
	title VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE employee (
	employee_id SERIAL PRIMARY KEY,
	hotel_id INT NOT NULL,
	position_id INT,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255),
	address VARCHAR(255),
	ssn_or_sin_no VARCHAR(255) UNIQUE NOT NULL,
	is_manager BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (hotel_id) REFERENCES hotel(hotel_id)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT,
	FOREIGN KEY (position_id) REFERENCES position(position_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE room (
	room_id SERIAL PRIMARY KEY,
	hotel_id INT NOT NULL,
	room_number VARCHAR(50) NOT NULL,
	price DECIMAL(10, 2) CHECK (price >= 0),
	amenities TEXT,
	capacity INT DEFAULT 2 CHECK (capacity >= 0),
	view TEXT CHECK (view IN ('None', 'Ocean', 'Mountain', 'Street')),
	is_extendable BOOLEAN DEFAULT FALSE,
	problems_and_damages TEXT,
	FOREIGN KEY (hotel_id) REFERENCES hotel(hotel_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	UNIQUE (hotel_id, room_number)
);

CREATE TABLE customer (
	customer_id SERIAL PRIMARY KEY,
	id_number VARCHAR(255) UNIQUE,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	type_of_id VARCHAR(255) NOT NULL CHECK (type_of_id IN ('SSN', 'SIN', 'License', 'Other')),
	registration_date DATE DEFAULT CURRENT_DATE
);

CREATE TABLE renting (
	renting_id SERIAL PRIMARY KEY,
	room_id INT NOT NULL,
	employee_id INT NOT NULL,
	customer_id INT NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	payment_status VARCHAR(255) CHECK (payment_status IN ('Pending', 'Paid', 'Refunded')),
	FOREIGN KEY (room_id) REFERENCES room(room_id)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT,
	FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
		ON DELETE SET NULL
		ON UPDATE RESTRICT,
	FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE booking (
	booking_id SERIAL PRIMARY KEY,
	room_id INT NOT NULL,
	customer_id INT NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	room_status VARCHAR(255) CHECK (room_status IN ('Booked', 'Cancelled', 'Pending')),
	payment_status VARCHAR(255) CHECK (payment_status IN ('Pending', 'Paid', 'Cancelled')),
	FOREIGN KEY (room_id) REFERENCES room(room_id)
		ON DELETE SET NULL
		ON UPDATE RESTRICT,
	FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE renting_archive (
	renting_archive_id SERIAL PRIMARY KEY,
	renting_id INT NOT NULL,
	room_snapshot JSON NOT NULL,
	customer_snapshot JSON NOT NULL,
	employee_snapshot JSON NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	archive_date DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE booking_archive (
	booking_archive_id SERIAL PRIMARY KEY,
	booking_id INT NOT NULL,
	room_snapshot JSON NOT NULL,
	customer_snapshot JSON NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	archive_date DATE NOT NULL DEFAULT CURRENT_DATE
);