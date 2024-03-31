# Hotel Management

## Set-up
- Clone repository locally
- Ensure you have `Postgres` and `PgAdmin` downloaded.
- Go to the `hotel/scripts` directory and execute each script in PgAdmin using the query tool to set-up the database schema and initial data.
- Go to `src/main/resources/application.properties` and make sure the database credentials are correct for your local database.
- Using `IntelliJ`, go to `src/main/java/HotelApplication.java` and run the application. 
- View in browser on `localhost:8080`.

## Implemented Features in the UI
- Features:
  - Adding, editing, deleting customers
  - Adding, editing, deleting hotel chains
  - Adding, editing, deleting hotels
  - Viewing rooms associated with a hotel
  - Filtering available rooms based on criteria

## Description
Five of the most well-known hotel chains, with hotels in more than 14 different locations in North
America, have decided to collaborate and develop an application that will allow their customers to
easily book rooms in their hotels, seeing room availability in real time. You are requested to develop
the database and the application that allows the above.

For every hotel chain we need to know the address of its central offices, the number of its hotels,
contact email addresses and phone numbers. The hotels of hotel chains are categorized (e.g. 1-star up
to 5-star). For each hotel we need to know the number of rooms, the address of the hotel and contact
email and phone numbers for this hotel. For the rooms in a hotel, we need to know their price, all
amenities (e.g. TV, air condition, fridge etc), the capacity of the room (e.g. single, double etc), if they
have sea view or mountain view, if they can be extended (e.g. adding one more bed) and if there are
any problems/damages in the room. 

For customers we need to store their full name, address and a type
of ID, e.g. SSN/SIN/driving licence, the date of their registration into our system. For employees of
the hotels, we need to store their full name, address and SSN/SIN. The employees may have various
roles/positions in a hotel. Every hotel needs to have a manager. The customers can search for and
book rooms through the online application for specific dates. When they check-in the hotel, their room
booking is transformed to renting and they can also pay for this renting. 

The employee that does the check-in for a customer is responsible for transforming the room booking to renting. A customer may
present physically at a hotel without a booking and directly ask for a room. In this case the employee
at the hotel can do the renting of the room right away without prior booking. We need to store in the
database the history of both bookings and rentings (archives), but we do not need to store the history
of payments. Information about an old (archived) room booking/renting must exist in the database,
even if information about the room itself or the customer does not exist in the database anymore. 

We
should be able to delete from our database hotel chains, hotels and rooms. We cannot have in the
database information about a room without having in the database the information about the
corresponding hotel (i.e. the hotel in which the room belongs too). In the same way, we cannot have in
the database information about a hotel without having in the database the information about the
corresponding hotel chain (i.e. the hotel chain in which the hotel belongs too).