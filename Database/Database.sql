DROP DATABASE IF EXISTS barbershopapp;
CREATE DATABASE IF NOT EXISTS barbershopapp;

USE barbershopapp;

CREATE TABLE IF NOT EXISTS user (
	user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS professional(
	professional_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS service(
	service_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS schedule (
	schedule_id INT AUTO_INCREMENT PRIMARY KEY,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    user_id INT,
    professional_id INT,
    service_id INT,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (professional_id) REFERENCES professional(professional_id),
    FOREIGN KEY (service_id) REFERENCES service(service_id)
);

INSERT INTO user(name, last_name, email, password)
VALUES("Jamel", "Morant", "jaMorant@gmail.com", "12345678");

INSERT INTO professional(name, last_name)
VALUES("Roger", "Brown");

INSERT INTO service(title, price)
VALUES("Haircut", "10.99");

INSERT INTO schedule(user_id, professional_id, service_id)
VALUES(1, 2, 1);

SELECT * FROM user;
SELECT * FROM professional;
SELECT * FROM service;
SELECT * FROM schedule;
