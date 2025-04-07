CREATE TABLE phones (
    person_id VARCHAR(255) PRIMARY KEY NOT NULL,
    ddd VARCHAR(3) NOT NULL,
    number VARCHAR(10) NOT NULL,
    CONSTRAINT fk_person_phone FOREIGN KEY (person_id) REFERENCES persons(id) ON DELETE CASCADE
);