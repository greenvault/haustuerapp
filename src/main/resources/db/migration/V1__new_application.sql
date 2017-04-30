CREATE TABLE topic(
  id serial PRIMARY KEY,
  description varchar(255) NOT NULL
);

CREATE TABLE usr(
  id serial PRIMARY KEY,
  email VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  password CHAR(60) NOT NULL,
  is_confirmed BOOLEAN NOT NULL,
  uid VARCHAR(255)
);

CREATE TABLE door(
  id serial PRIMARY KEY,
  address_city VARCHAR(255) NOT NULL,
  address_country VARCHAR(255) NOT NULL,
  address_street VARCHAR(255) NOT NULL,
  address_zip VARCHAR(255) NOT NULL,
  geolocation_longitude DECIMAL,
  geolocation_latitude DECIMAL,
  door_opened boolean NOT NULL,
  -- TODO add checks?
  reaction INTEGER NOT NULL,
  probability_to_vote INTEGER NOT NULL,
  notes TEXT,
  created_at TIMESTAMP NOT NULL,
  creator_id INTEGER REFERENCES usr(id)
);
