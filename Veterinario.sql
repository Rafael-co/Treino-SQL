CREATE DATABASE veterinario;

 CREATE TABLE clientes(
 IDcliente INTEGER PRIMARY KEY AUTO_INCREMENT,
 nomeCliente VARCHAR(50) NOT NULL,
 idade INTEGER NOT NULL,
 email VARCHAR(50) NOT NULL UNIQUE,
 telefone INTEGER NOT NULL
 );
 CREATE TABLE pet(
 IDpet INTEGER PRIMARY KEY AUTO_INCREMENT,
 nomePet VARCHAR(50) NOT NULL,
 idade INTEGER NOT NULL,
 especie VARCHAR(50) NOT NULL,
 raça VARCHAR(50) NOT NULL,
 IDcliente INTEGER NOT NULL,
 FOREIGN KEY (IDcliente) REFERENCES clientes(IDcliente)  
 );
 CREATE TABLE servicos(
 IDservico INTEGER PRIMARY KEY AUTO_INCREMENT,
 servico VARCHAR(50) NOT NULL,
 preco DECIMAL(10,2)NOT NULL

  
 );


 CREATE TABLE rel_cliente_servicos(
 
 IDrel_cliente_servicos INTEGER PRIMARY KEY AUTO_INCREMENT,
 IDcliente INTEGER NOT NULL,
 IDservicos INTEGER NOT NULL,
 dataDoServico DATE NOT NULL,
 IDpet INTEGER NOT NULL,
 FOREIGN KEY (IDpet) REFERENCES pet(IDpet),
 FOREIGN KEY (IDcliente) REFERENCES clientes(IDcliente),
 FOREIGN KEY (IDservicos) REFERENCES servicos(IDservico)
  
 
 );
 SHOW TABLES;
 SELECT* FROM clientes;
 SELECT* FROM pet;
 SELECT* FROM servicos;
 SELECT*FROM rel_cliente_servicos;
 


 INSERT INTO clientes(nomeCliente,idade,email,telefone) VALUES("Rafael Camilo De Oliveira",25,"rafael.camil@gmail.com",41612073),("Gabriel Camilo De Oliveira",22,"gabriel.camil@youtube.com",47856221);
 INSERT INTO pet(nomePet,idade,especie,raça,IDcliente) VALUES("felcia",4,"Felino","Gaatus folgadus",1),("Banguela",3,"felino","Gatus medrousus",1),("Toto",9,"canino","Cachorrus fedidus",2);
 INSERT INTO servicos(servico,preco)VALUES("Lavagem",25.00),("Vacinação completa",150.0),("tosa",25.0),("Consulta",150.00),("raio-x",200.00);
 INSERT INTO rel_cliente_servicos(IDcliente,IDservicos,dataDoServico,IDpet)VALUES(1,6,"2022-11-22",1),(1,7,"2022-10-01",2),(2,9,"2022-11-10",3);

UPDATE servicos
SET preco = 200
WHERE servico = "Consulta";


DELETE from rel_cliente_servicos
WHERE IDrel_cliente_servicos = 1; 


 -- BUSCA DE SERVIÇOS DE CLIENTES PENDENDTES
 SELECT nomeCliente,nomePet,servico,preco,dataDoServico FROM rel_cliente_servicos
 INNER JOIN clientes
 ON rel_cliente_servicos.IDcliente = clientes.IDcliente
 INNER JOIN pet 
 ON rel_cliente_servicos.IDpet = pet.IDpet
 INNER JOIN servicos
 ON rel_cliente_servicos.IDservicos = servicos.IDservico
  where dataDoServico > CURRENT_DATE()
 order by dataDoServico;
 
 -- BUSCA POR SERVIÇOS PENDENTES, DO MAIS CARO PARA O MAIS BARATO
SELECT nomeCliente,nomePet,servico,preco,dataDoServico FROM rel_cliente_servicos
 INNER JOIN clientes
 ON rel_cliente_servicos.IDcliente = clientes.IDcliente
 INNER JOIN pet 
 ON rel_cliente_servicos.IDpet = pet.IDpet
 INNER JOIN servicos
 ON rel_cliente_servicos.IDservicos = servicos.IDservico
 WHERE dataDoServico > CURRENT_DATE()
 ORDER BY preco DESC;
 
 -- BUSCA DO CONTATO DO DONO DO PET
 SELECT nomeCliente,nomePet,telefone,email
 FROM clientes
 INNER JOIN pet 
 ON clientes.IDcliente=pet.IDcliente;
 
 -- BUSCA DE TODOS OS SERVIÇOS FEITO POR UM CLIENTE 
 SELECT nomeCliente,nomePet,servico,preco,dataDoServico FROM rel_cliente_servicos
 INNER JOIN clientes
 ON rel_cliente_servicos.IDcliente = clientes.IDcliente
 INNER JOIN pet 
 ON rel_cliente_servicos.IDpet = pet.IDpet
 INNER JOIN servicos
 ON rel_cliente_servicos.IDservicos = servicos.IDservico
 WHERE nomeCliente  LIKE "RAFAEL %"
 ;
 
  -- BUSCA DO TOTAL A DEVER DO CLIENTE (CONSIDERANDO QUE NENHUM DOS SERVIÇOS FOI PAGO) 
 SELECT nomeCliente,SUM(preco) AS total FROM rel_cliente_servicos
 INNER JOIN clientes
 ON rel_cliente_servicos.IDcliente = clientes.IDcliente
 INNER JOIN pet 
 ON rel_cliente_servicos.IDpet = pet.IDpet
 INNER JOIN servicos
 ON rel_cliente_servicos.IDservicos = servicos.IDservico
 WHERE nomeCliente LIKE "Rafael %";
 
 -- BUSCA DE QUANTOS PETS UM CLIENTE TEM
 SELECT nomeCliente,NomePet 
 FROM pet
 INNER JOIN clientes
 ON pet.IDcliente = clientes.IDcliente;
 
 