use renascence_finix;

INSERT INTO category_first_level (name) VALUES ("C1_PC");        -- id = 1

INSERT INTO category_first_level (name) VALUES ("C2_Printer");   -- id = 2

INSERT INTO category_first_level (name) VALUES ("C3_CellPhone"); -- id = 3

INSERT INTO category_second_level (name, first_level_id) VALUES ("C11_Laptop", 1);

INSERT INTO category_second_level (name, first_level_id) VALUES ("C12_Desktop", 1);

INSERT INTO category_second_level (name, first_level_id) VALUES ("C21_LaserJet", 2);

INSERT INTO category_second_level (name, first_level_id) VALUES ("C22_NonLaserJet", 2);

INSERT INTO category_second_level (name, first_level_id) VALUES ("C31_SmartHPPhone", 3);

INSERT INTO category_second_level (name, first_level_id) VALUES ("C32_iPhone", 3);
