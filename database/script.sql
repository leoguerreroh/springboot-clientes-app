CREATE DATABASE IF NOT EXISTS test;
USE test;

CREATE TABLE usuario (
  id_usuario INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(45),
  password VARCHAR(128)
);

CREATE TABLE persona (
  id_persona INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(45),
  apellido VARCHAR(45),
  email VARCHAR(45),
  telefono VARCHAR(45),
  saldo DOUBLE
);

CREATE TABLE rol (
  id_rol INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(45),
  id_usuario INT,
  FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

-- Datos
INSERT INTO usuario VALUES 
(1,'admin','$2a$10$PDpLCLarJoRwrh46nH4UQeLVlHe97pT5HaJ71DsUQGb5ohLcB5Vda'),
(2,'user','$2a$10$MgHuMUiNryXknFqd/l6m6uEQlX2vCMRbXOVXNZ3BglLg27NBkUDBS');

INSERT INTO rol VALUES 
(1,'ROLE_ADMIN',1),
(2,'ROLE_USER',1),
(3,'ROLE_USER',2);

INSERT INTO persona VALUES 
(1,'Juan','Perez','jperez@mail.com','4846548',100),
(2,'Karla','Gomez','kgomez@mail.com','4568446',150),
(3,'Carlos','Lara','clara@mail.com','4845865',200),
(5,'Laura1','Cantu2','lcantu@mail.com3','98980964',130.05);