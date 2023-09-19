create database biblioteca_fx;
use biblioteca_fx;

create table livro(
	id bigint (20) auto_increment primary key,
    nome_livro varchar (500) not null, 
    autor varchar (540) not null, 
    preco double not null
);

insert into livro value (null, 'romeu e julieta', 'shakespeare', 12.67);
insert into livro value (null, 'Os 6 anéis', 'Phil Jackson', 22.89);

select * from livro;