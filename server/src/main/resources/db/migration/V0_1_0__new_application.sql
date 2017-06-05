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
  address_zip VARCHAR(255) NOT NULL,
  geolocation_longitude DOUBLE PRECISION,
  geolocation_latitude DOUBLE PRECISION,
  door_opened boolean NOT NULL,
  -- TODO add checks?
  reaction INTEGER NOT NULL,
  probability_to_vote INTEGER NOT NULL,
  notes TEXT,
  created_at TIMESTAMP NOT NULL,
  creator_id BIGINT REFERENCES usr(id)
);

CREATE TABLE door_topic(
  topics_id BIGINT,
  door_id BIGINT,
  FOREIGN KEY (topics_id) REFERENCES topic(id),
  FOREIGN KEY (door_id) REFERENCES door(id)
);

CREATE TABLE oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

CREATE TABLE oauth_client_token (
  token_id VARCHAR(256),
  token BYTEA,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

CREATE TABLE oauth_access_token (
  token_id VARCHAR(256),
  token BYTEA,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication BYTEA,
  refresh_token VARCHAR(256)
);

CREATE TABLE oauth_refresh_token (
  token_id VARCHAR(256),
  token BYTEA,
  authentication BYTEA
);

CREATE TABLE oauth_code (
  code VARCHAR(256), authentication BYTEA
);

CREATE TABLE oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);
