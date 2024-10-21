-- Tabela de Estados
CREATE TABLE tb_state (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    abbreviation VARCHAR(10) NOT NULL
);

-- Tabela de Cidades
CREATE TABLE tb_city (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    state_id UUID,
    FOREIGN KEY (state_id) REFERENCES tb_state(id) ON DELETE CASCADE
);

-- Tabela de Clientes
CREATE TABLE tb_client (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    city_id UUID,
    active BOOLEAN NOT NULL,
    birthday DATE NOT NULL,
    FOREIGN KEY (city_id) REFERENCES tb_city(id) ON DELETE SET NULL
);

-- Tabela de Filhos
CREATE TABLE tb_child (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birthday DATE NOT NULL,
    client_id UUID,
    FOREIGN KEY (client_id) REFERENCES tb_client(id) ON DELETE CASCADE
);

-- Tabela de Usuários
CREATE TABLE tb_user (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL
);
