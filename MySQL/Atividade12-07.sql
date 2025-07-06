create schema CasaDeAdocao;

use CasaDeAdocao;

create table Animal (
    ID_Animal int not null auto_increment Primary Key,
    Nome varchar(50) not null,
    CaminhoImg varchar(255),
    Descricao varchar(200),
    data_nas DATE,
    Raca varchar(30) not null,
    Adotado boolean default false 
);

create table Cachorro (
    ID_Cachorro int not null Primary Key, 
    E_Treinado Boolean,
    Foreign Key (ID_Cachorro) references Animal(ID_Animal)
);

create table Passaro (
    ID_Passaro int not null Primary Key, 
    Pode_Voar boolean,
    Pode_Falar boolean,
    Foreign Key (ID_Passaro) references Animal(ID_Animal)
);

create table Gato (
    ID_Gato int not null Primary Key, 
    Foreign Key (ID_Gato) references Animal(ID_Animal)
);
    
create table Pessoa (
    ID_Pessoa int not null auto_increment Primary Key,
    Nome varchar(50) not null,
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

create table Adotante (
    ID_Adotante int not null Primary Key,
    Carteira_Adotante varchar(20),
    Foreign Key (ID_Adotante) references Pessoa(ID_Pessoa)
);

create table Funcionario (
    ID_Funcionario int not null Primary Key,
    Matricula varchar(20),
    Foreign Key (ID_Funcionario) references Pessoa(ID_Pessoa)
);

create table Adocao (
    ID_Adocao int not null auto_increment Primary Key,
    ID_Animal int not null,
    ID_Adotante int not null,
    Data_Adocao date not null,
    foreign key (ID_Animal) references Animal(ID_Animal),
    foreign key (ID_Adotante) references Adotante(ID_Adotante)
);

insert into Animal (Nome, CaminhoImg, Descricao, data_nas, Raca, Adotado) values
	("Mufasa", "img/mufasa.jpg", "Ator e paciente", "2020-05-12", "Bobtail americano", FALSE),
    ("Bob", "img/bob.jpg", "Nervoso e protetor", "2019-03-23", "Siâmes", FALSE),
    ("Mingau", "img/mingau.jpg", "Divertido e carinhoso", "2020-03-10", "Persa Chinchila", FALSE),
    ("Pipoca", "img/pipoca.jpg", "Dócil e brincalhona", "2024-01-15", "Calopsita", FALSE),
    ("Chico", "img/chico.jpg", "Inteligente e curioso", "2024-02-08", "Ring Neck", FALSE),
    ("Rocky", "img/rocky.jpg", "Charmoso e compacto", "2024-09-20", "Bulldog Francês", FALSE),
    ("Belinha", "img/belinha.jpg", "Pequena e carismática", "2023-11-07", "Pug", FALSE),
    ("Buddy", "img/buddy.jpg", "Inteligente e ativo", "2024-03-25", "Border Collie", FALSE),
    ("Nina", "img/nina.jpg", "Elegante e afetuosa", "2023-07-29", "Angorá", FALSE),
    ("Estrela", "img/estrela.jpg", "Ativa e divertida", "2024-06-30", "Diamante Mandarim", FALSE);
    
insert into Cachorro (ID_Cachorro, E_Treinado) values
	(6, FALSE), (7, FALSE), (8, TRUE), (11, FALSE),
    (12, TRUE), (13, TRUE), (14, FALSE), (15, TRUE),
    (16, FALSE), (17, TRUE);

insert into Passaro (ID_Passaro, Pode_Voar, Pode_Falar) values
	(4, TRUE, FALSE), (5, TRUE, FALSE), (10, FALSE, FALSE),
    (18, TRUE, TRUE), (19, TRUE, TRUE), (20, FALSE, FALSE),
    (21, FALSE, TRUE), (22, FALSE, TRUE), (23, FALSE, TRUE),
    (24, TRUE, TRUE);
    
insert into Gato (ID_Gato) values
	(1), (2), (3), (9), (25),
    (26), (27), (28), (29), (30);
    
insert into Pessoa (Nome, Email, CEP, Cidade, Estado, Logradouro, Complemento, date_nas, Senha, Telefone, CPF) values
('Ana Clara Souza', 'ana.souza@example.com', '86010-010', 'Londrina', 'PR', 'Rua Brasil', 'Apto 202', '1990-05-15', 'senha123', '(43) 99988-7766', '111.222.333-44'),
('Bruno Costa', 'bruno.costa@example.com', '86020-020', 'Londrina', 'PR', 'Avenida Higienópolis', 'Sala 5', '1985-08-20', 'senha456', '(43) 98877-6655', '222.333.444-55'),
('Carla Dias', 'carla.dias@example.com', '86030-030', 'Londrina', 'PR', 'Rua Santos', NULL, '1992-02-10', 'senha789', '(43) 97766-5544', '333.444.555-66'),
('Daniel Martins', 'daniel.martins@example.com', '86040-040', 'Londrina', 'PR', 'Avenida Dez de Dezembro', 'Casa A', '1988-11-30', 'senha101', '(43) 96655-4433', '444.555.666-77'),
('Eduarda Lima', 'eduarda.lima@example.com', '86050-050', 'Londrina', 'PR', 'Rua da Gente', 'Bloco B, Apto 101', '2000-07-25', 'senha202', '(43) 95544-3322', '555.666.777-88'),
('Fábio Pereira', 'fabio.pereira@example.com', '86060-060', 'Londrina', 'PR', 'Avenida Maringá', NULL, '1995-04-12', 'senha303', '(43) 94433-2211', '666.777.888-99'),
('Gabriela Alves', 'gabriela.alves@example.com', '86070-070', 'Londrina', 'PR', 'Rua Pernambuco', 'Fundos', '1998-09-05', 'senha404', '(43) 93322-1100', '777.888.999-00'),
('Heitor Rocha', 'heitor.rocha@example.com', '86080-080', 'Londrina', 'PR', 'Rua do Café', 'Apto 505', '1982-01-18', 'senha505', '(43) 92211-0099', '888.999.000-11'),
('Isabela Santos', 'isabela.santos@example.com', '86015-090', 'Londrina', 'PR', 'Rua Goiás', NULL, '2001-03-22', 'senha606', '(43) 91100-9988', '999.000.111-22'),
('João Mendes', 'joao.mendes@example.com', '86025-100', 'Londrina', 'PR', 'Avenida Juscelino Kubitschek', 'Loja 3', '1993-06-08', 'senha707', '(43) 99999-8877', '000.111.222-33'),
('Lucas Oliveira', 'lucas.oliveira@example.com', '86035-110', 'Londrina', 'PR', 'Rua Prefeito Faria Lima', 'Apto 301', '1991-10-14', 'funcsenha1', '(43) 98888-7777', '123.456.789-10'),
('Mariana Ferreira', 'mariana.ferreira@example.com', '86045-120', 'Londrina', 'PR', 'Rua Guaporé', 'Casa B', '1989-12-01', 'funcsenha2', '(43) 97777-6666', '234.567.891-01'),
('Nicolas Barros', 'nicolas.barros@example.com', '86055-130', 'Londrina', 'PR', 'Avenida Ayrton Senna', 'Andar 10', '1994-08-19', 'funcsenha3', '(43) 96666-5555', '345.678.910-12'),
('Olivia Ribeiro', 'olivia.ribeiro@example.com', '86065-140', 'Londrina', 'PR', 'Rua Bento Viana', NULL, '1987-05-23', 'funcsenha4', '(43) 95555-4444', '456.789.101-23'),
('Pedro Gonçalves', 'pedro.goncalves@example.com', '86075-150', 'Londrina', 'PR', 'Rua Humaitá', 'Apto 804', '1999-02-28', 'funcsenha5', '(43) 94444-3333', '567.891.012-34'),
('Quintino Azevedo', 'quintino.azevedo@example.com', '86085-160', 'Londrina', 'PR', 'Rua Quintino Bocaiúva', 'Casa 1', '1984-07-11', 'funcsenha6', '(43) 93333-2222', '678.910.123-45'),
('Renata Cavalcanti', 'renata.cavalcanti@example.com', '86010-170', 'Londrina', 'PR', 'Rua Pio XII', 'Bloco C', '1996-09-03', 'funcsenha7', '(43) 92222-1111', '789.101.234-56'),
('Sérgio Nogueira', 'sergio.nogueira@example.com', '86020-180', 'Londrina', 'PR', 'Rua Pará', 'Apto 1201', '1980-11-07', 'funcsenha8', '(43) 91111-0000', '891.012.345-67'),
('Tatiana Correia', 'tatiana.correia@example.com', '86030-190', 'Londrina', 'PR', 'Avenida Rio de Janeiro', NULL, '2002-01-09', 'funcsenha9', '(43) 90000-9999', '910.123.456-78'),
('Ulisses Brandão', 'ulisses.brandao@example.com', '86040-200', 'Londrina', 'PR', 'Rua Sergipe', 'Sala 15', '1997-06-17', 'funcsenha10', '(43) 98765-4321', '012.345.678-90');

insert into Adotante (ID_Adotante, Carteira_Adotante) values
(1, 'ADOT-001'),
(2, 'ADOT-002'),
(3, 'ADOT-003'),
(4, 'ADOT-004'),
(5, 'ADOT-005'),
(6, 'ADOT-006'),
(7, 'ADOT-007'),
(8, 'ADOT-008'),
(9, 'ADOT-009'),
(10, 'ADOT-010');

insert into Funcionario (ID_Funcionario, Matricula) values
(11, 'FUNC-2025-001'),
(12, 'FUNC-2025-002'),
(13, 'FUNC-2025-003'),
(14, 'FUNC-2025-004'),
(15, 'FUNC-2025-005'),
(16, 'FUNC-2025-006'),
(17, 'FUNC-2025-007'),
(18, 'FUNC-2025-008'),
(19, 'FUNC-2025-009'),
(20, 'FUNC-2025-010');

insert into Adocao (ID_Animal, ID_Adotante, Data_Adocao) values
(1, 1, '2023-03-01'),
(2, 2, '2023-03-05'),
(4, 4, '2023-04-15'),
(6, 5, '2023-05-20'),
(8, 8, '2023-06-10');

-- Liste os nomes dos animais adotados, junto com o nome do adotante.

select a.Nome Animal, p.Nome Adotante
from Animal a
join Adocao ad on a.ID_Animal = ad.ID_Animal
join Adotante adot on ad.ID_Adotante = adot.ID_Adotante
join Pessoa p on p.ID_Pessoa = adot.ID_Adotante;

-- Mostre os nomes dos gatos que ainda não foram adotados.

select a.nome
from gato g
join animal a on g.id_gato = a.id_animal
where a.adotado = false;

-- Quantos animais há de cada raça?

select raca, count(*) as quantidade
from animal
group by raca
order by quantidade desc;

-- Mostre os nomes dos adotantes que moram em "rua brasil" ou "rua goiás".

select p.nome
from pessoa p
join adotante a on p.id_pessoa = a.id_adotante
where p.logradouro in ('rua brasil', 'rua goiás');

-- Mostre os 5 animais mais velhos cadastrados.

select nome, data_nas
from animal
order by data_nas
limit 5;

-- Liste todos os pássaros que não podem voar.

select a.nome
from passaro p
join animal a on a.id_animal = p.id_passaro
where p.pode_voar = false;

-- Mostre os funcionários cujo e-mail contém "example.com".

select p.nome, p.email
from pessoa p
join funcionario f on p.id_pessoa = f.id_funcionario
where p.email like '%example.com%';

-- Quantos cachorros são treinados e quantos não são?

select c.e_treinado as treinado, count(*) as quantidade
from cachorro c
group by c.e_treinado;

-- Mostre os nomes dos animais com descrição contendo "brinca" ou "divertido".

select nome, descricao
from animal
where descricao like '%brinca%' or descricao like '%divertido%';

-- Quantas adoções foram feitas em cada mês?

select month(data_adocao) as mes, count(*) as total_adocoes
from adocao
group by month(data_adocao)
order by mes;

-- Liste os nomes dos animais com raça que começa com a letra "b".

select nome, raca
from animal
where raca like 'b%';

-- Qual é a menor e maior data de nascimento dos animais?

select min(data_nas) as mais_velho, max(data_nas) as mais_novo
from animal;

-- Quantos animais foram adotados por cada pessoa (mostrar nome do adotante)?

select p.nome, count(ad.id_adocao) as total_adotados
from adocao ad
join adotante adot on ad.id_adotante = adot.id_adotante
join pessoa p on adot.id_adotante = p.id_pessoa
group by p.nome
order by total_adotados desc;

-- Mostre os nomes dos animais com o mesmo ano de nascimento que o adotante.

select ani.nome as animal, ani.data_nas as nasc_animal, p.nome as adotante, p.date_nas as nasc_adotante
from adocao ad
join animal ani on ad.id_animal = ani.id_animal
join adotante a on ad.id_adotante = a.id_adotante
join pessoa p on a.id_adotante = p.id_pessoa
where year(ani.data_nas) = year(p.date_nas);

-- Mostre os nomes e raças dos animais que já foram adotados e possuem na descrição a palavra "carinhoso"

select nome, raca, descricao
from animal
where adotado = true and descricao like '%carinhoso%';
