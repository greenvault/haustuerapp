CREATE TABLE door_topic(
	topics_id INT,
	door_id INT,
	FOREIGN KEY (topics_id) REFERENCES topic(id),
	FOREIGN KEY (door_id) REFERENCES door(id)
)
