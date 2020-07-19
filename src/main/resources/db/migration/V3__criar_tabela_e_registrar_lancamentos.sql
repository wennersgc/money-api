create table lancamento (
	codigo bigserial primary key,
	descricao varchar(50) not null,
	data_vencimento date not null,
	data_pagamento date,
	valor decimal(10, 2) not null,
	observacao varchar(20),
	tipo varchar(20) not null,
	codigo_categoria bigserial,
	codigo_pessoa bigserial,
	FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo),
	FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo)
);

insert into lancamento(descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
values ('Mensalidade', '2012-12-18', '2012-12-19', 123.99, 'paga', 'DESPESA', 2, 4);

insert into lancamento(descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
values ('Aluguel', '2012-12-18', '2012-12-19', 123.99, 'paga', 'RECEITA', 2, 5);

insert into lancamento(descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
values ('Combustivel', '2012-12-18', '2012-12-19', 123.99, 'paga', 'DESPESA', 2, 6);

insert into lancamento(descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
values ('Motel', '2012-12-18', '2012-12-19', 123.99, 'paga', 'DESPESA', 2, 4);

insert into lancamento(descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
values ('Escola', '2012-12-18', '2012-12-19', 123.99, 'paga', 'DESPESA', 2, 7);
