create table categoria(
	codigo bigint(20) primary key auto_increment,
    nome varchar(50) not null
);

insert into categoria(nome) value ('Lazer');
insert into categoria(nome) value ('Comida');
insert into categoria(nome) value ('Esportes');
insert into categoria(nome) value ('Outros');
