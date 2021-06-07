CREATE TABLE IF NOT EXISTS cliente (
    cd_Cliente serial PRIMARY KEY,
    cd_Cpf  varchar(14) not null,
    nm_Cliente  varchar(50),
    ds_Email varchar (150) not null  unique,
    ds_Endereco varchar (200),
    ds_Cidade varchar (50),
    sg_Uf char(2),
    cd_Cep varchar (10),
    cd_Telefone varchar (20),
    cd_Senha varchar (256) not null,
    enabled boolean not null default true,
    authority varchar(20) not null default 'USER' check (authority = 'USER')
    );

CREATE TABLE IF NOT EXISTS produto (
    cd_Produto serial PRIMARY KEY,
    nm_Produto varchar(50) not null,
    nm_Genero varchar(50),
    nm_Categoria varchar(50),
    ds_Produto varchar (200) not null,
    nm_Marca varchar (50),
    nm_Cor varchar (50),
    ds_Tamanho char(4),
    vl_Produto real not null,
    CONSTRAINT Categorias CHECK (nm_Categoria IN ('Botas','Chinelos e Sandálias','Chuteiras', 'Sapatilhas','Tênis', 'Tênis Performance')),
    CONSTRAINT Generos CHECK (nm_Genero IN ('Masculino', 'Feminino', 'Infantil'))
    );

CREATE TABLE IF NOT EXISTS fornecedor(
    cd_Fornecedor serial PRIMARY KEY,
    nm_Fornecedor varchar(50) not null,
    ds_Fornecedor varchar (200) not null,
    nm_Contato varchar (50) not null,
    cd_Telefone varchar (20) not null,
    ds_Email varchar (150)
    );

CREATE TABLE IF NOT EXISTS funcionario (
    cd_Funcionario serial PRIMARY KEY,
    cd_Cpf  varchar(14) not null,
    nm_Funcionario  varchar(50),
    ds_Cargo varchar (100),
    ds_Email varchar (150) not null  unique,
    ds_Endereco varchar (200),
    ds_Cidade varchar (50),
    sg_Uf char(2),
    cd_Cep varchar (10),
    cd_Telefone varchar (20),
    cd_Senha varchar (256) not null,
    enabled boolean not null default true,
    authority varchar(20) not null,
    CONSTRAINT autoridade_check CHECK (authority IN ('ADMINISTRATIVO', 'ATENDENTE'))
);



