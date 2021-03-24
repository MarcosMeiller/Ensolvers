# EnsolversExercise

Username: user
password: 123456

requirements:
Java 11.
Spring Boot 2.4.4.
Maven.
MySql 8.0.21.
jdk 11


Database tables:

create database ensolversapp;

CREATE TABLE folders (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE tasks(
  id INT NOT NULL AUTO_INCREMENT,
  id_folder INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  status TINYINT NOT NULL DEFAULT 0,
  CONSTRAINT PRIMARY KEY (id),
  CONSTRAINT id FOREIGN KEY (id_folder) REFERENCES folders(id) ON DELETE CASCADE
);
  
