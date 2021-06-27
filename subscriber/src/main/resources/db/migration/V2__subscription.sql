
    CREATE TABLE subscription (
        id BIGSERIAL NOT NULL,
        msisdn int8 NOT NULL,
        action VARCHAR(255) NOT NULL,
        timestamp timestamp NOT NULL,
        PRIMARY KEY (id));