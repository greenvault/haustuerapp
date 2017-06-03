CREATE TABLE door_topic(
	topics_id BIGINT,
	door_id BIGINT,
	FOREIGN KEY (topics_id) REFERENCES topic(id),
	FOREIGN KEY (door_id) REFERENCES door(id)
)
