create table pessoa (
	codigo bigserial primary key,
	nome varchar(50) not null,
	ativo boolean,
	logradouro varchar(50),
	numero varchar(10),
	bairro varchar(50),
	cep varchar(30),
	cidade varchar(50),
	estado varchar(50)
);

insert into pessoa(nome, ativo, logradouro, numero, bairro, cep, cidade, estado)
				values('Wenner', true, 'rua 2', '31', 'Tijupá Queimado', '65110-000', 'São José de Ribamar', 'Maranhão');
insert into pessoa(nome, ativo, logradouro, numero, bairro, cep, cidade, estado)
				values('Sander', true, 'rua 2', '31', 'Tijupá Queimado', '65110-000', 'São José de Ribamar', 'Maranhão');
insert into pessoa(nome, ativo, logradouro, numero, bairro, cep, cidade, estado)
				values('Gabriel', true,'rua 2', '31', 'Tijupá Queimado', '65110-000', 'São José de Ribamar', 'Maranhão');
insert into pessoa(nome, ativo, logradouro, numero, bairro, cep, cidade, estado)
				values('Thompson', false, 'rua 2', '31', 'Tijupá Queimado', '65110-000', 'São José de Ribamar', 'Maranhão');
insert into pessoa(nome, ativo, logradouro, numero, bairro, cep, cidade, estado)
				values('Lorena', false, 'rua 2', '31', 'Tijupá Queimado', '65110-000', 'São José de Ribamar', 'Maranhão');
insert into pessoa(nome, ativo, logradouro, numero, bairro, cep, cidade, estado)
				values('Otavio', false, 'rua 2', '31', 'Tijupá Queimado', '65110-000', 'São José de Ribamar', 'Maranhão');
insert into pessoa(nome, ativo, logradouro, numero, bairro, cep, cidade, estado)
				values('Valentina', false, 'rua 2', '31', 'Tijupá Queimado', '65110-000', 'São José de Ribamar', 'Maranhão');
insert into pessoa(nome, ativo, logradouro, numero, bairro, cep, cidade, estado)
				values('Cássia', false, 'rua 2', '31', 'Tijupá Queimado', '65110-000', 'São José de Ribamar', 'Maranhão');