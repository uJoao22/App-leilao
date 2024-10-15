-- Endereço
CREATE SEQUENCE seq_endereco INCREMENT 1 MINVALUE 1 MAXVALUE 9999999 START 1 CACHE 1;

CREATE TABLE endereco (
  id INTEGER DEFAULT nextval('seq_endereco'::regclass) NOT NULL,
  logradouro VARCHAR(64),
  municipio VARCHAR(64),
  numero VARCHAR(10),
  complemento VARCHAR(64),
  bairro VARCHAR(64),
  cep VARCHAR(16),
  created_at TIMESTAMP DEFAULT NOW() NOT NULL,
  updated_at TIMESTAMP DEFAULT NOW() NOT NULL
);

ALTER TABLE endereco ADD CONSTRAINT endereco_pk PRIMARY KEY (id);

-- Empresa
CREATE SEQUENCE seq_empresa INCREMENT 1 MINVALUE 1 MAXVALUE 9999999 START 1 CACHE 1;

CREATE TABLE empresa (
  id INTEGER DEFAULT nextval('seq_empresa'::regclass) NOT NULL,
  razao_social VARCHAR(64) NOT NULL,
  cnpj VARCHAR(32) NOT NULL,
  id_endereco INTEGER NOT NULL,
  telefone VARCHAR(32),
  email VARCHAR(254) NOT NULL,
  site VARCHAR(254),
  usuario VARCHAR(20) NOT NULL,
  senha VARCHAR(128),
  created_at TIMESTAMP DEFAULT NOW() NOT NULL,
  updated_at TIMESTAMP DEFAULT NOW() NOT NULL
);

ALTER TABLE empresa ADD CONSTRAINT empresa_pk PRIMARY KEY (id);
ALTER TABLE empresa ADD CONSTRAINT empresa_cnpj_uk UNIQUE (cnpj);
ALTER TABLE empresa ADD CONSTRAINT empresa_usuario_uk UNIQUE (usuario);
ALTER TABLE empresa ADD CONSTRAINT empresa_endereco_fk FOREIGN KEY (id_endereco) REFERENCES endereco ON DELETE CASCADE;

-- Leilao
CREATE SEQUENCE seq_leilao INCREMENT 1 MINVALUE 1 MAXVALUE 9999999 START 1 CACHE 1;

CREATE TABLE leilao (
  id INTEGER DEFAULT nextval('seq_leilao'::regclass) NOT NULL,
  codigo INTEGER,
  descricao VARCHAR(60) NOT NULL,
  vendedor INTEGER NOT NULL,
  inicio_previsto TIMESTAMP NOT NULL,
  created_at TIMESTAMP DEFAULT NOW() NOT NULL,
  updated_at TIMESTAMP DEFAULT NOW() NOT NULL
);

ALTER TABLE leilao ADD CONSTRAINT leilao_pk PRIMARY KEY (id);

-- Lote
CREATE SEQUENCE seq_lote INCREMENT 1 MINVALUE 1 MAXVALUE 9999999 START 1 CACHE 1;

CREATE TABLE lote (
  id INTEGER DEFAULT nextval('seq_lote'::regclass) NOT NULL,
  numero_lote INTEGER,
  descricao VARCHAR(60) NOT NULL,
  quantidade NUMERIC NOT NULL,
  valor_inicial NUMERIC,
  unidade VARCHAR(128) NOT NULL,
  id_leilao INTEGER NOT NULL,
  created_at TIMESTAMP DEFAULT NOW() NOT NULL,
  updated_at TIMESTAMP DEFAULT NOW() NOT NULL
);

ALTER TABLE lote ADD CONSTRAINT lote_pk PRIMARY KEY (id);
ALTER TABLE lote ADD CONSTRAINT leilao_lote_fk FOREIGN KEY (id_leilao) REFERENCES leilao;

-- Unidade
CREATE SEQUENCE seq_unidade INCREMENT 1 MINVALUE 1 MAXVALUE 9999999 START 1 CACHE 1;

CREATE TABLE unidade (
  id INTEGER DEFAULT nextval('seq_unidade'::regclass) NOT NULL,
  nome VARCHAR(128) NOT NULL,
  created_at TIMESTAMP DEFAULT NOW() NOT NULL,
  updated_at TIMESTAMP DEFAULT NOW() NOT NULL
);

ALTER TABLE unidade ADD CONSTRAINT unidade_pk PRIMARY KEY (id);

-- Comprador
CREATE TABLE comprador (
  id_empresa INTEGER NOT NULL,
  id_leilao INTEGER NOT NULL
);

ALTER TABLE comprador ADD CONSTRAINT comprador_pk PRIMARY KEY (id_empresa, id_leilao);
ALTER TABLE comprador ADD CONSTRAINT leilao_empresa_fk FOREIGN KEY (id_leilao) REFERENCES leilao ON DELETE CASCADE;
ALTER TABLE comprador ADD CONSTRAINT comprador_empresa_fk FOREIGN KEY (id_empresa) REFERENCES empresa ON DELETE CASCADE;
