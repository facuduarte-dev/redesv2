CREATE DATABASE IF NOT EXISTS escaner_red;

USE escaner_red;

DROP TABLE IF EXISTS equipos;

CREATE TABLE equipos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ip VARCHAR(15) NOT NULL,
    mac VARCHAR(20),
    activo BOOLEAN,
    CONSTRAINT uk_ip UNIQUE (ip)
);