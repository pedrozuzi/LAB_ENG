create database ecommerce
go
use ecommerce



create table cliente(
id int not null,
nome varchar(100),
telefone varchar(12),

cep varchar(8),
uf varchar(2),
cidade varchar(20),
bairro varchar(20),
rua varchar (50),
num int,
complemento varchar(10) 

primary key(id)
)

create table usuario(

id
email
senha
foreign key ( id ) references cliente(id)

)

create table pedido()

create table produto()

create table itempedido()