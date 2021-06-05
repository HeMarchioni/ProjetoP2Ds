CREATE TABLE IF NOT EXISTS cliente (
    cd_Cliente serial PRIMARY KEY,
    cd_Cpf  varchar(14) not null unique,
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
    cd_Cpf  varchar(14) not null unique,
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
    CONSTRAINT autoridade_check CHECK (authority IN ('ADM', 'ATEND'))
);



CREATE TABLE IF NOT EXISTS vendas (
    cd_Venda serial primary key,
    cd_Cpf varchar(14) references cliente (cd_Cpf),
    vl_Total real not null
);



CREATE TABLE IF NOT EXISTS vendasProduto (
    cd_Venda int references vendas (cd_Venda),
    cd_Produto int references produto (cd_Produto),
    qt_Produto int check (qt_Produto > 0),
    vl_Unidade real not null,
    primary key (cd_Venda, cd_Produto)
);

CREATE TABLE IF NOT EXISTS estoque(
    cd_Produto int references produto (cd_Produto),
    cd_Fornecedor int references fornecedor (cd_Fornecedor),
    qt_Estoque int not null,
    primary key (cd_Produto, cd_Fornecedor)
);
