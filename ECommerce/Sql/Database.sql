create database ecommerce
go
use ecommerce

drop database ecommerce


create table usuario(

id int not null identity primary key,
email VARCHAR(320),
--senha varbinary(32),
senha varchar(32),
)

create table cliente(
id int not null identity,
idUsuario int,
nome varchar(100),
telefone varchar(12),
cep varchar(8),
uf varchar(2),
cidade varchar(20),
bairro varchar(20),
rua varchar (50),
num int,
complemento varchar(10) 
foreign key (idUsuario) references usuario(id)
primary key(id)
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
categoria int,
marca varchar(40),
imagem varchar(40)
primary key(id)
foreign key (categoria) references categoria (idcat)

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
(6,1,'Fogão'),
(7,2,'Nootbook'),
(8,2,'Desktop'),
(9,3,'Futebol'),
(10,3,'Bicicleta'),
(11,4,'TV Led'),
(12,4,'Smart TV')
---------------------------------
insert into produto values
(1,'geladeira',1500,'com geloplux',5,'consul','geladeira1.jpg'),
(2,'geladeira',1100,'sem geloplux',5,'eletrolux','geladeira2.jpg'),
(3,'fogão',900,'eletrico',6,'marca','fogao1.jpg'),
(4,'fogão',700,'gas encanado',6,'macra','fogao2.jpg'),
(5,'nootbook',2000,'I7 4° geração',7,'marca','nootbook1.jpg'),
(6,'nootbook',1200,'celeron',7,'marca','nootbook2.jpg'),
(7,'desktop',3000,'PC Gamer',8,'marca','desktop1.jpg'),
(8,'desktop',1500,'i3',8,'marca','desktop2.jpg'),
(9,'futebol',50,'Camisa Argentina',9,'marca','futebol1.jpg'),
(10,'futebol',120,'Camisa Brasil',9,'marca','futebol2.jpg'),
(11,'bicicleta',400,'aro 26',10,'marca','bicicleta1.jpg'),
(12,'bicicleta',690,'aro 24 equipada',10,'marca','bicicleta2.jpg'),
(13,'tv led',3000,'2k',11,'marca','tvled1.jpg'),
(14,'tv led',5000,'4k',11,'marca','tvled2.jpg'),
(15,'smart tv',6500,'Android',12,'marca','smart1.jpg'),
(16,'smart tv',6000,'wifi',7,'marca','smart2.jpg')

-----------------------


--------------------------------
select * from usuario
select * from cliente
delete usuario
delete cliente

insert into cliente values
(3, 'Pedro', '1111', '11111', 'sp', 'sao paulo', 'bairro', 'rua', 1, '12')

---------

/**
View responsavel pela apresentaÃ§Ã£o das categorias e suas sub-Categorias.
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
select Sub_Categoria from v_categoria where sub_categoria like 'nootbook'

-------------------------------
alter VIEW v_prodcat
as
select prod.nome as Nome, cat.nome as Categoria, cat.idcat from produto prod
inner join categoria cat
on prod.categoria = cat.idcat

where idcat = 5
-----------------------------
select * from v_prodcat where idcat = 5

select * from produto
