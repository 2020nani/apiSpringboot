INSERT INTO pessoa (nome, sobrenome, nascimento, cpf, email ) VALUES ('hernani','Almeida','11101984', '12345678912','her@hotmail.com');
INSERT INTO pessoa (nome, sobrenome, nascimento, cpf, email ) VALUES ('nani','Alme','12101984', '02345678912','hr@hotmail.com');
INSERT INTO pessoa (nome, sobrenome, nascimento, cpf, email ) VALUES ('heni','Almei','13101984', '22345678912', 'her@hotmail.com');
INSERT INTO pessoa (nome, sobrenome, nascimento, cpf, email ) VALUES ('her','Al','14101984', '32345678912', 'her@hotmail.com');
INSERT INTO pessoa (nome, sobrenome, nascimento, cpf, email ) VALUES ('nini','Alm','15101984', '42345678912', 'her@hotmail.com');

INSERT INTO endereco (rua, numero, complemento, bairro, cidade, estado,codigo_pessoa ) VALUES ('1',3456,'casa','jd oliv', 'botucatu','sp',(SELECT codigo FROM pessoa WHERE cpf = '12345678912'));
INSERT INTO endereco (rua, numero, complemento, bairro, cidade, estado,codigo_pessoa ) VALUES ('2',34565,'casa', 'jd olivei', 'botuc', 'sp',(SELECT codigo FROM pessoa WHERE cpf = '02345678912'));
INSERT INTO endereco (rua, numero, complemento, bairro, cidade, estado,codigo_pessoa ) VALUES ('3',345656,'casa', 'jd oliveira', 'botutu', 'sp',(SELECT codigo FROM pessoa WHERE cpf = '42345678912'));