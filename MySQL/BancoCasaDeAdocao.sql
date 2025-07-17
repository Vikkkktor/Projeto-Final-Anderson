CREATE SCHEMA casadeadocao;

USE casadeadocao;

CREATE TABLE animal (
    id_animal INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    caminhoimg VARCHAR(255),
    descricao VARCHAR(200),
    idade ENUM('Filhote', 'Jovem', 'Adulto', 'Idoso'),
    sexo CHAR(1),
    porte ENUM ('Pequeno', 'Médio', 'Grande'),
    especie ENUM ('Passaro', 'Cachorro', 'Gato'),
    castrado BOOLEAN NOT NULL DEFAULT FALSE,
    raca VARCHAR(30) NOT NULL
);
    
CREATE TABLE adotante (
    id_adotante INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    cep VARCHAR(9) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    complemento VARCHAR(50),
    date_nas DATE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    telefone VARCHAR(16) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE
);

CREATE TABLE adocao (
    id_adocao INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_animal INT NOT NULL,
    id_adotante INT NOT NULL,
    data_adocao DATE NOT NULL,
    FOREIGN KEY (id_animal) REFERENCES animal(id_animal),
    FOREIGN KEY (id_adotante) REFERENCES adotante(id_adotante)
);
