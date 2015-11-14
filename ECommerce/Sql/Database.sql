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

id int not null,
email VARCHAR(320),
--senha varbinary(32),
senha varchar(32),
foreign key ( id ) references cliente(id)
)


--64 characters for the "local part" (username).
--1 character for the @ symbol.
--255 characters for the domain name.

--SHA-256 has a 256 bit output
--256bits = 32 Bytes
--So try varbinary(32)

create table pedido(

id int not null,
data datetime not null,
valor decimal(7,2) not null
primary key (id)

)

create table produto(

id int not null,
nome varchar (100),
valor decimal(7,2),
descricao varchar(max),
categoria int
primary key(id)

)

create table itempedido(

valor decimal(7,2) not null,
quantidade int not null,
idProduto int not null,
idPedido int not null
foreign key (idProduto) references produto(id),
foreign key (idPedido) references pedido(id)

)

create table categoria(
idcat int not null,
idsubcat int,
nome varchar(30) not null,

primary key (idcat),
foreign key (idsubcat) references categoria (idcat)
)

---------------------------------
insert into categoria values 
(1,null,'Eletrodomestico'),
(2,null,'Informatica'),
(3,null,'Esporte'),
(4,null,'Eletronica'),
(5,1,'Geladeira'),
(6,1,'Fog�o'),
(7,2,'Nootbook'),
(8,2,'Desktop'),
(9,3,'Futebol'),
(10,3,'Bicicleta'),
(11,4,'TV Led'),
(12,4,'Smart TV')
---------------------------------

/**
View responsavel pela apresentação das categorias e suas sub-Categorias.
*/

CREATE VIEW v_categoria
as
    SELECT 
        cat.nome as Categoria,   
        sub.nome as Sub_Categoria
    FROM 
        categoria sub
            INNER JOIN 
            categoria cat 
            ON sub.idsubcat 
            =  cat.idcat
----------------------------            
select Sub_Categoria from v_categoria where Categoria like 'informatica'



