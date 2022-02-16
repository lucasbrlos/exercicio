/* criando base de dados */
create database db_ecommerce;

/* criando tabela da base de dados */
use db_ecommerce;
create table tb_produtos(
	id bigint(5) auto_increment,
    preco decimal(5, 2) not null,
    nome varchar(30) not null,
    marca varchar(15),
    categoria varchar(25) not null,
    quantidade int(5) not null,
    
    primary key (id)
);

/* populando tabela tb_produtos */

insert into tb_produtos(preco, nome, marca, categoria, quantidade)
	values(749.99, "Monitor", "Samsung", "Eletronicos", 35);

insert into tb_produtos(preco, nome, marca, categoria, quantidade)
	values(1199.99, "Celular", "LG", "Eletronicos", 60);

insert into tb_produtos(preco, nome, marca, categoria, quantidade)
	values(74.99, "Teclado", "Logitech", "Eletronicos", 100);

insert into tb_produtos(preco, nome, marca, categoria, quantidade)
	values(1499.99, "Celular", "Samsung", "Eletronicos", 74);

insert into tb_produtos(preco, nome, marca, categoria, quantidade)
	values(2099.99, "Tablet", "Samsung", "Eletronicos", 50);

insert into tb_produtos(preco, nome, marca, categoria, quantidade)
	values(2299.99, "TV", "LG", "Eletronicos", 20);

insert into tb_produtos(preco, nome, marca, categoria, quantidade)
	values(99.50, "Panela", "Polishop", "Utensilios", 150);

insert into tb_produtos(preco, nome, marca, categoria, quantidade)
	values(2999.99, "Geladeira", "Brastemp", "Eletrodomesticos", 10);

select * from tb_produtos;
/* produtos com valor maior que 500 */
select * from tb_produtos where preco > 500;

/* produtos com valor menos que 500 */
select * from tb_produtos where preco < 500;

/* atualizando o dado da geladeira que entrou em promocao */

update tb_produtos set preco = 2499.99
	where nome = "Geladeira" and
    marca = "Brastemp";

