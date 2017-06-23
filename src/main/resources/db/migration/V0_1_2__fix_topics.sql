DROP TABLE survey_response_topic;
DROP TABLE topic;

CREATE TABLE topic(
  key varchar(255) PRIMARY KEY,
  description varchar(10000) NOT NULL
);

CREATE TABLE survey_response_topic(
  topics_key varchar(255),
  survey_response_id BIGINT,
  FOREIGN KEY (topics_key) REFERENCES topic(key),
  FOREIGN KEY (survey_response_id) REFERENCES survey_response(id)
);
