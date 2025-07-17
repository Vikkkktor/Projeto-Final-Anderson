create schema CasaDeAdocao;

use CasaDeAdocao;

create table Animal (
    ID_Animal int not null auto_increment Primary Key,
    Nome varchar(50) not null,
    CaminhoImg varchar(255),
    Descricao varchar(200),
    idade enum('Filhote', 'Jovem', 'Adulto', 'Idoso'),
    sexo char(1),
    porte enum ('Pequeno', 'Médio', 'Grande'),
    especie enum ('Passaro', 'Cachorro', 'Gato'),
    castrado boolean not null default false,
    Raca varchar(30) not null
);

create table Adotante (
    ID_Adotante int not null auto_increment Primary Key,
    Nome varchar(50) not null,
    Sobrenome varchar(50) not null,
    Email varchar(255) not null unique,
    CEP varchar(9) not null,
    Cidade varchar(50) not null,
    Estado varchar(2) not null,
    Logradouro varchar(100) not null,
    Complemento varchar(50),
    date_nas DATE not null,
    Senha varchar(255) not null,
    Telefone varchar(16) not null,
    CPF varchar(14) not null unique
);

create table Adocao (
    ID_Adocao int not null auto_increment Primary Key,
    ID_Animal int not null,
    ID_Adotante int not null,
    Data_Adocao date not null,
    foreign key (ID_Animal) references Animal(ID_Animal),
    foreign key (ID_Adotante) references Adotante(ID_Adotante)
);