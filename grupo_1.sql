DROP DATABASE IF EXISTS bd;
CREATE DATABASE bd;

USE bd;

CREATE TABLE dados_mvc(id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
nome VARCHAR(45) NOT NULL, 
telefone VARCHAR(15) NOT NULL);

