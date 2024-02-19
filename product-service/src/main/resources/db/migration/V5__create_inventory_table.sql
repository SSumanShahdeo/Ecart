
CREATE TABLE inventory (
	inventory_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    quantity INT,
	is_available BOOLEAN,
	created_at TIMESTAMP DEFAULT LOCALTIMESTAMP NOT NULL NULL_TO_DEFAULT,
	updated_at TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);