create database projeto;

create table funcionarios(
id int not null auto_increment primary key,
nome varchar(40),
rgf varchar(9),
cpf varchar(11),
rg varchar(8)
)

create table fornecedores(
id int not null auto_increment primary key,
nome varchar(40),
ie varchar(9),
endereco varchar(90),
cep varchar(11)
)