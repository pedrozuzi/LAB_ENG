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
senha varbinary(32),
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

valor decimal(7,2) not null
quantidade int not null,
idProduto int not null,
idPedido int not null
foreign key (idProduto) references produto(id)
foreign key (idPedido) references pedido(id)

)

create table categoria(
idcat int not null,
idsubcat int,
nome varchar(30) not null,

primary key (idcat)
foreign key (idsubcat) references categoria (idcat)
)

/*
insert into categoria values 
(1,null,'info'),
(2,null,'casa'),
(3,1,'hard'),
(4,1,'soft'),
(5,2,'eletro'),
(6,2,'mobilia')

SELECT 
    cat.nome,   
    categoria.nome
FROM 
    categoria
        INNER JOIN 
        categoria cat 
        ON categoria.idsubcat 
        =  cat.idcat
*/




/*
Criando uma auto-unir com um relacionamento reflexivo   Você pode associar uma tabela a mesma usando uma relação
reflexiva — uma relação em que as colunas de chave externa faz referência e colunas de chave primária conhecida
para estão na mesma tabela. Por exemplo, suponha que a tabela de funcionários contenha uma coluna adicional
gerente_funcionário_id_func e que uma chave estrangeira existe de gerente__id_func para funcionário_id_func.
Em cada linha da tabela de funcionários, a coluna gerente_id_func indica o chefe do funcionário. Mais precisamente,
ele indica a id_func do chefe do funcionário.
Ao associar a tabela a mesma usando esse relação reflexiva, você pode estabelecer um conjunto no qual cada linha
contém o nome do chefe e o nome de um dos funcionários desse chefe de resultados. A SQL resultante pode parecer
como este:

SELECT 
    boss.lname, 
    boss.fname, 
    employee.lname, 
    employee.fname
FROM 
    employee
        INNER JOIN 
        employee boss 
        ON employee.manager_emp_id 
        =  boss.emp_id
*/

CREATE VIEW v_produtos
as

