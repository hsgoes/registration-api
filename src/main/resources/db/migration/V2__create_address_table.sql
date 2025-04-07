CREATE TABLE addresses (
    person_id VARCHAR(255) PRIMARY KEY NOT NULL,
    zip_code VARCHAR(10) NOT NULL,
    state VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    neighborhood VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    number VARCHAR(10) NOT NULL,
    CONSTRAINT fk_person_address FOREIGN KEY (person_id) REFERENCES persons(id) ON DELETE CASCADE
);
