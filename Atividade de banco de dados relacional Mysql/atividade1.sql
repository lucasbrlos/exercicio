/* criar banco de dados para o RH */
create database db_recursos_humanos;

/* criar tabela para os funcionarios 
com 5 atributos*/
use db_recursos_humanos;
create table tb_funcionaries(
	id bigint(3) auto_increment,
    nome varchar(50) not null,
    data_aniversario date,
    email varchar(75) not null,
    celular varchar(15),
    salario int(5) not null,
    
    primary key (id)
);

/* retonar funcionarios com salario maior
que 2000 */

select * from tb_funcionaries
	where salario > 2000;

/* retornar funcionarios com salario menor
que 2000 */

select * from tb_funcionaries
	where salario < 2000;

/* atualizar um dado */

update tb_funcionaries set salario = 9999
	where nome like "%Dal Topaz%";