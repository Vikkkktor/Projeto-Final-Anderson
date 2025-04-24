create schema CasaDeAdocao;

use CasaDeAdocao;

create table Animal (
	ID_Animal int not null auto_increment Primary Key,
    	Nome varchar(50) not null,
	Descricao varchar(200),
    	Idade int not null,
   	Raca varchar(30) not null,
    	Adotado boolean default false,
);

create table Cachorro (
	ID_Cachorro int Primary Key,
	E_Treinado Boolean,
	Foreign Key (ID_Cachorro) references Animal(ID_Animal)
);

create table Passaro (
	ID_Passaro int Primary Key,
	Pode_Voar boolean,
	Pode_Falar boolean,
	Foreign Key (ID_Passaro) references Animal(ID_Animal)
);

create table Gato (
	ID_Gato int Primary Key,
	Foreign Key (ID_Gato) references Animal(ID_Animal)
);
	
create table Pessoa (
	ID_Pessoa int not null auto_increment Primary Key,
    	Nome varchar(50) not null,
    	Endereco varchar(70),
    	Idade int not null,
   	Telefone varchar(16) not null,
	CPF varchar(14) unique,
);	

create table Adotante (
	ID_Adotante int Primary Key,
	Carteira_Adotante varchar(20),
	Foreign Key (ID_Adotante) references Pessoa(ID_Pessoa)
);

create table Funcionario (
	ID_Funcionario int Primary Key,
	Matricula varchar(20),
	Foreign Key (ID_Funcionario) references Pessoa(ID_Pessoa)
);

create table Adocao (
	ID_Adocao int not null auto_increment Primary Key,
    ID_Animal int not null,
    ID_Pessoa int not null,
    Data_Adocao date not null,
    foreign key (ID_Animal) references Animal(ID_Animal),
    foreign key (ID_Pessoa) references Pessoa(ID_Pessoa)
);
