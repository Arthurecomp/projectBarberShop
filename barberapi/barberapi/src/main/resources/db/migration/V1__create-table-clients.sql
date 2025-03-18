CREATE TABLE CLIENTS (
                         id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(150) NOT NULL,
                         email VARCHAR(150) NOT NULL UNIQUE,
                         phone CHAR(11) NOT NULL UNIQUE
);
