CREATE TABLE `user`( 
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar(20) NOT NULL,
	is_active BOOLEAN NOT NULL,
	is_adult BOOLEAN NOT NULL,
	pocket float NOT NULL
);

CREATE TABLE product( 
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	product_name varchar(20) NOT NULL,
	is_for_adult BOOLEAN NOT NULL,
	price float NOT NULL
);
