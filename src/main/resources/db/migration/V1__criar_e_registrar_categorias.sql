create table categoria(
	codigo bigserial primary key,
    nome varchar(50) not null
);

insert into categoria(nome) values ('Lazer');
insert into categoria(nome) values ('Comida');
insert into categoria(nome) values ('Esportes');
insert into categoria(nome) values ('Outros');
