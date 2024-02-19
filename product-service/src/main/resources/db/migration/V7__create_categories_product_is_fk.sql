
ALTER TABLE products
  ADD CONSTRAINT fk1_assign FOREIGN KEY (category_id) REFERENCES categories (category_id);

ALTER TABLE products
  ADD CONSTRAINT fk2_assign FOREIGN KEY (inventory_id) REFERENCES inventory (inventory_id);
