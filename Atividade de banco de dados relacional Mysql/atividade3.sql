/* criando banco de dados da escola */
create database db_escola;

/* criando tabela de estudantes */
use db_escola;
create table tb_estudantes(
	id bigint auto_increment,
    nome varchar(45) not null,
    matricula int(15),
    data_nascimento date,
    nota decimal(2, 1),
    faltas int(2),
    
    primary key (id)
);
select * from tb_estudantes;
insert into tb_estudantes(nome, matricula, data_nascimento, nota, faltas)
    values("João Silva", null, "2010-12-01", 4.2, 4);

insert into tb_estudantes(nome, matricula, data_nascimento, nota, faltas)
    values("João Medeiros", 938459384, "2012-05-23", 9.6, 1);    

insert into tb_estudantes(nome, matricula, data_nascimento, nota, faltas)
    values("Gustavo Mendonça", 203945839, "2009-08-05", 0.0, 15);

insert into tb_estudantes(nome, matricula, data_nascimento, nota, faltas)
    values("Maria Oliveira", null, "2010-11-25", 8.7, 2);

insert into tb_estudantes(nome, matricula, data_nascimento, nota, faltas)
    values("Marcos Silva", 32543252, "2010-03-08", 6.8, 7);

insert into tb_estudantes(nome, matricula, data_nascimento, nota, faltas)
    values("Giovana Mendes", 3314542, "2015-06-06", 8.3, 3);

insert into tb_estudantes(nome, matricula, data_nascimento, nota, faltas)
    values("Carolina Barbosa", 664655523, "2008-02-05", 5.5, 1);

insert into tb_estudantes(nome, matricula, data_nascimento, nota, faltas)
    values("Maria Silva", 74927548, "2006-04-12", 8.9, 0);

insert into tb_estudantes(nome, matricula, data_nascimento, nota, faltas)
    values("Julia Silva", null, "2006-04-12", 9.1, 1);

select * from tb_estudantes where nota > 7.0;

select * from tb_estudantes where nota < 7.0;

update tb_estudantes set nota = 9.5
	where nome = "Maria Silva";
