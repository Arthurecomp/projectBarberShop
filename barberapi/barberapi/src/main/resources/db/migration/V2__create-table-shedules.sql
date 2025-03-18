CREATE TABLE SCHEDULES (
                           id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           start_at TIMESTAMP NOT NULL,
                           end_at TIMESTAMP NOT NULL,
                           client_id BIGINT NOT NULL,
                           FOREIGN KEY (client_id) REFERENCES CLIENTS(id)
);
