
CREATE TABLE products (
	product_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	category_id INT,
	inventory_id INT,
	quantity INT,
	product_title VARCHAR(255),
	image_url VARCHAR(255) DEFAULT 'https://bootdey.com/img/Content/avatar/avatar7.png',
	price_unit DECIMAL(11,2),
	created_at TIMESTAMP DEFAULT LOCALTIMESTAMP NOT NULL NULL_TO_DEFAULT,
	updated_at TIMESTAMP
);

