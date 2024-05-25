CREATE TABLE IF NOT EXISTS tasks (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     description VARCHAR(255),
    status INTEGER,
    creation_date TIMESTAMP
    );
