CREATE TABLE `order`(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	product_id int NOT NULL,
	user_id int NOT NULL,
	amount int NOT NULL,
	unit_price float NOT NULL,
	total_price float NOT NULL,
	FOREIGN KEY (product_id) REFERENCES product(id),
	FOREIGN KEY (user_id) REFERENCES `user`(id)
)