-- Insert Country
INSERT INTO country (id, name, continent) VALUES (1, 'France', 'Europe');
INSERT INTO country (id, name, continent) VALUES (2, 'Italy', 'Europe');

-- Insert Hosts
INSERT INTO host (id, name, surname, country_id) VALUES (1, 'Alice', 'Smith', 1);
INSERT INTO host (id, name, surname, country_id) VALUES (2, 'Bob', 'Rossi', 2);

-- Insert Accommodations
INSERT INTO accommodation (id, name, category, host_id, num_rooms, rented, price) VALUES (1, 'Luxury Apartment', 'APARTMENT', 1, 3, FALSE, 150.0);
INSERT INTO accommodation (id, name, category, host_id, num_rooms, rented, price) VALUES (2, 'Rustic Cabin', 'HOUSE', 2, 2, TRUE, 100.0);


-- Guests
INSERT INTO guest (id, name, email, host_id) VALUES (1, 'Elena Petrova', 'elena@example.com', 1);
INSERT INTO guest (id, name, email, host_id) VALUES (2, 'Ivan Markovski', 'ivan@example.com', 2);

-- Sample Reviews
INSERT INTO review (id, comment, rating, date, guest_id, accommodation_id) VALUES
(1, 'Great stay, very clean!', 5, '2024-12-20', 1, 1),
(2, 'Cozy place but a bit noisy.', 3, '2025-01-05', 2, 2);

-- Insert Reservations
INSERT INTO reservation (id, start_date, end_date, guest_id, accommodation_id)
VALUES (1, '2025-06-01', '2025-06-10', 1, 1);

-- Availability (assuming accommodation IDs 1 and 2 already exist)
INSERT INTO availability (start_date, end_date, accommodation_id) VALUES ('2025-06-01', '2025-06-15', 1);
INSERT INTO availability (start_date, end_date, accommodation_id) VALUES ('2025-07-01', '2025-07-10', 2);

-- Parking Spots
INSERT INTO PARKING_SPOT (covered, accommodation_id, id, location) VALUES (TRUE, 1, 1, 'A1');
