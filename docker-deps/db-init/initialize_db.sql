CREATE USER test WITH PASSWORD 'password';
DROP DATABASE IF EXISTS testdb;
CREATE DATABASE testdb OWNER test ENCODING 'UTF-8';