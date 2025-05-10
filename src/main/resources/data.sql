-- Insert Country
INSERT INTO country (id, name, continent) VALUES (1, 'France', 'Europe');
INSERT INTO country (id, name, continent) VALUES (2, 'Italy', 'Europe');

-- Insert Hosts
INSERT INTO host (id, name, surname, country_id) VALUES (1, 'Alice', 'Smith', 1);
INSERT INTO host (id, name, surname, country_id) VALUES (2, 'Bob', 'Rossi', 2);

-- Insert Accommodations
INSERT INTO accommodation (id, name, category, host_id, num_rooms, rented) 
VALUES (1, 'Luxury Apartment', 'APARTMENT', 1, 3, FALSE);

INSERT INTO accommodation (id, name, category, host_id, num_rooms, rented) 
VALUES (2, 'Rustic Cabin', 'HOUSE', 2, 2, TRUE);
