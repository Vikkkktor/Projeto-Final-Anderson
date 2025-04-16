create schema CasaDeAdocao;

use CasaDeAdocao;

create table Animal (
	ID_Animal int not null auto_increment Primary Key,
    Nome varchar(50) not null,
    Idade int not null,
    Raca varchar(30) not null,
    Adotado boolean default false,
    Especie enum ('Cachorro', 'Gato', 'Pássaro') not null,
    -- Atributos especificos por espécie
    Pode_Voar boolean null comment 'Apenas para pássaros',
    Pode_Falar boolean null comment 'Apenas para pássaros',
    E_Treinado boolean null comment 'Apenas para cachorros'
);

create table Pessoa (
	ID_Pessoa int not null auto_increment Primary Key,
    Nome varchar(50) not null,
    Endereco varchar(70),
    Idade int not null,
    Telefone varchar(16) not null,
	CPF varchar(14) not null unique,
    Funcao enum ('Adotante', 'Funcionário') not null,
    Carteira_Adotante varchar(20) null comment 'Apenas para Adotante'
);	

create table Adocao (
	ID_Adocao int not null auto_increment Primary Key,
    ID_Animal int not null,
    ID_Pessoa int not null,
    Data_Adocao date not null,
    foreign key (ID_Animal) references Animal(ID_Animal),
    foreign key (ID_Pessoa) references Pessoa(ID_Pessoa)
);
