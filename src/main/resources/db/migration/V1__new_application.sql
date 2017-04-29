CREATE TABLE door(id serial PRIMARY KEY, latitude varchar(255), longitude varchar(255));
CREATE TABLE topic(
  id serial PRIMARY KEY,
  description varchar(255) NOT NULL
);