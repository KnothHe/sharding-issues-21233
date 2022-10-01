# COMMENT: This SQL with DROP table json_test0 and json_test1, be careful.

CREATE DATABASE IF NOT EXISTS ds0;
USE ds0;
DROP TABLE IF EXISTS json_test0;
CREATE TABLE json_test0
(
    id         BIGINT NOT NULL
        PRIMARY KEY,
    json_field JSON   NULL
);
USE ds0;
DROP TABLE IF EXISTS json_test1;
CREATE TABLE json_test1
(
    id         BIGINT NOT NULL
        PRIMARY KEY,
    json_field JSON   NULL
);

CREATE DATABASE IF NOT EXISTS ds1;
USE ds1;
DROP TABLE IF EXISTS json_test0;
CREATE TABLE json_test0
(
    id         BIGINT NOT NULL
        PRIMARY KEY,
    json_field JSON   NULL
);
USE ds1;
DROP TABLE IF EXISTS json_test1;
CREATE TABLE json_test1
(
    id         BIGINT NOT NULL
        PRIMARY KEY,
    json_field JSON   NULL
);

INSERT INTO ds0.json_test0
(id, json_field) VALUES (2, '{"key":"value"}');
