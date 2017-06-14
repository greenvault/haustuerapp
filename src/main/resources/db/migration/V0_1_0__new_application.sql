CREATE TABLE topic(
  id bigserial PRIMARY KEY,
  description varchar(255) NOT NULL
);

CREATE TABLE usr(
  id bigserial PRIMARY KEY,
  email VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  password VARCHAR(60) NOT NULL
);


CREATE TABLE door(
  id bigserial PRIMARY KEY,
  address_city VARCHAR(255) NOT NULL,
  address_country VARCHAR(255) NOT NULL,
  address_street VARCHAR(255) NOT NULL,
  address_number VARCHAR(255),
  address_zip VARCHAR(255) NOT NULL,
  geolocation_longitude DOUBLE PRECISION,
  geolocation_latitude DOUBLE PRECISION,
  created_at TIMESTAMP NOT NULL,
  creator VARCHAR(255) NOT NULL
);

CREATE TABLE survey_response(
  id bigserial PRIMARY KEY,
  address_city VARCHAR(255) NOT NULL,
  address_country VARCHAR(255) NOT NULL,
  address_street VARCHAR(255) NOT NULL,
  address_number VARCHAR(255),
  address_zip VARCHAR(255) NOT NULL,
  geolocation_longitude DOUBLE PRECISION,
  geolocation_latitude DOUBLE PRECISION,
  door_opened boolean NOT NULL,
  -- TODO add checks?
  reaction INTEGER NOT NULL,
  probability_to_vote INTEGER NOT NULL,
  notes TEXT,
  created_at TIMESTAMP NOT NULL,
  creator VARCHAR(255) NOT NULL
);

CREATE TABLE survey_response_topic(
  topics_id BIGINT,
  survey_response_id BIGINT,
  FOREIGN KEY (topics_id) REFERENCES topic(id),
  FOREIGN KEY (survey_response_id) REFERENCES survey_response(id)
);
