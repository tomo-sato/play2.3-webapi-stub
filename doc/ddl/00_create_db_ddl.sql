-- Creation a database. 
CREATE DATABASE `webapi_stub` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Creation an user.for the database. 
GRANT ALL PRIVILEGES ON webapi_stub.* TO webapi_stub_user@localhost IDENTIFIED BY 'webapi_stub123';
GRANT ALL PRIVILEGES ON webapi_stub.* TO webapi_stub_user@'%' IDENTIFIED BY 'webapi_stub123';

-- Reflects the all privileges as above
FLUSH PRIVILEGES;
