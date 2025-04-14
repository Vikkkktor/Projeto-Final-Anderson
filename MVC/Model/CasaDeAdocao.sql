create schema CasaDeAdocao;

use CasaDeAdocao;

create table Animal (
	ID_Animal int not null auto_increment Primary Key,
    Nome varchar(50) not null,
    Especie varchar(50) not null,
    Idade int not null,
    Cor varchar(10) not null,
    Adotado boolean default false,
    Tipo enum ('Cachorro', 'Gato', 'Pássaro') not null
);

create table Pessoa (
	ID_Pessoa int not null auto_increment Primary Key,
    Nome varchar(50) not null,
    Endereco varchar(70),
    Idade int not null,
    Telefone varchar(16) not null,
	CPF varchar(14) not null unique,
    Funcao enum ('Adotante', 'Funcionário') not null
);
