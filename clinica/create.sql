CREATE TABLE IF NOT EXISTS USUARIO (
ID int auto_increment primary key,
NOME varchar(16),
EMAIL varchar(48),
SENHA varchar(10),
NIVEL_ACESSO varchar (10));

INSERT INTO USUARIO (NOME, EMAIL, SENHA, NIVEL_ACESSO) VALUES ('MARCOS', 'MARCOS@EMAIL.COM', '1234', 'ADMIN');
INSERT INTO USUARIO (NOME, EMAIL, SENHA, NIVEL_ACESSO) VALUES ('ANA', 'ANA@EMAIL.COM', '1234', 'USER');
INSERT INTO USUARIO (NOME, EMAIL, SENHA, NIVEL_ACESSO) VALUES ('MARCIA', 'MARCIA@EMAIL.COM', '1234', 'USER');
INSERT INTO USUARIO (NOME, EMAIL, SENHA, NIVEL_ACESSO) VALUES ('VITORIA', 'VITORIA@EMAIL.COM', '1234', 'USER');