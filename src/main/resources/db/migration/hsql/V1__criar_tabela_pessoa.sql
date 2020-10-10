CREATE SEQUENCE pessoa_id_seq AS BIGINT START WITH 1 INCREMENT BY 1;
CREATE TABLE pessoa (
 codigo BIGINT GENERATED BY DEFAULT AS SEQUENCE pessoa_id_seq PRIMARY KEY,
 nome VARCHAR(30) NOT NULL,
 sobrenome VARCHAR(30) NOT NULL,
 nascimento VARCHAR(8) NOT NULL,
 cpf VARCHAR(11) NOT NULL,
 email VARCHAR(30) NOT NULL
);