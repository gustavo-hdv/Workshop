--
-- File generated with SQLiteStudio v3.2.1 on sáb ago 29 13:35:31 2020
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: audit_history
DROP TABLE IF EXISTS audit_history;
CREATE TABLE audit_history (id INTEGER PRIMARY KEY AUTOINCREMENT, "action" TEXT, action_date_time NUM, user_id INTEGER REFERENCES users (id), veiculo_id INTEGER REFERENCES veiculos (id), orcamento_id INTEGER REFERENCES orcamentos (id_orcamento), servico_id INTEGER REFERENCES servicos (id), cliente_id INTEGER REFERENCES clientes (id), produto_id INTEGER REFERENCES produtos (id), funcionario_id INTEGER REFERENCES funcionarios (id), empresa_id INTEGER REFERENCES config (id), usuario_id INTEGER REFERENCES users (id));

-- Table: clientes
DROP TABLE IF EXISTS clientes;
CREATE TABLE clientes (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, telefone TEXT, email TEXT, endereco TEXT);

-- Table: config
DROP TABLE IF EXISTS config;
CREATE TABLE config (id INTEGER DEFAULT '1', telefone TEXT DEFAULT NULL, email TEXT DEFAULT NULL, endereco TEXT DEFAULT NULL, company_name TEXT, PRIMARY KEY (id));
INSERT INTO config (id, telefone, email, endereco, company_name) VALUES (1, 'Não definido', 'Não definido', 'Não definido', 'Não definido');

-- Table: funcionarios
DROP TABLE IF EXISTS funcionarios;
CREATE TABLE funcionarios (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT);

-- Table: orcamentos
DROP TABLE IF EXISTS orcamentos;
CREATE TABLE orcamentos (id_orcamento INTEGER PRIMARY KEY, data_hora TEXT, forma_pagamento TEXT, defeitos_apontados TEXT, observacoes TEXT, cliente_id INTEGER, funcionario_id INTEGER, veiculo_id INTEGER, servicos_ids TEXT, produtos_ids TEXT);

-- Table: produtos
DROP TABLE IF EXISTS produtos;
CREATE TABLE produtos (id INTEGER PRIMARY KEY AUTOINCREMENT, descricao TEXT, quantidade INT, valor_unitario REAL);

-- Table: servicos
DROP TABLE IF EXISTS servicos;
CREATE TABLE servicos (id INTEGER PRIMARY KEY AUTOINCREMENT, descricao TEXT, quantidade INT, valor_unitario REAL);

-- Table: users
DROP TABLE IF EXISTS users;
CREATE TABLE users (id INTEGER PRIMARY KEY, login TEXT, password TEXT, is_admin INT);

-- Table: veiculos
DROP TABLE IF EXISTS veiculos;
CREATE TABLE veiculos (id INTEGER PRIMARY KEY AUTOINCREMENT, placa TEXT, descricao TEXT, quilometragem TEXT, combustivel TEXT, marcador TEXT, cor TEXT);

-- Index: empresa_id
DROP INDEX IF EXISTS empresa_id;
CREATE UNIQUE INDEX empresa_id ON config (id);

-- View: view_orcamentoinner
DROP VIEW IF EXISTS view_orcamentoinner;
CREATE VIEW view_orcamentoinner AS SELECT
 id_orcamento,
 data_hora,
 forma_pagamento,
 defeitos_apontados,
 observacoes,
 servicos_ids,
 produtos_ids,
 clientes.id AS cliente_id,
 clientes.nome AS cliente_nome,
 clientes.telefone AS cliente_telefone,
 clientes.email AS cliente_email,
 clientes.endereco AS cliente_endereco,
 funcionarios.id AS funcionario_id,
 funcionarios.nome AS funcionario_nome,
 veiculos.id AS veiculo_id,
 veiculos.placa AS veiculo_placa,
 veiculos.descricao AS veiculo_descricao,
 veiculos.quilometragem AS veiculo_quilometragem,
 veiculos.combustivel AS veiculo_combustivel,
 veiculos.marcador AS veiculo_marcador,
 veiculos.cor AS veiculo_cor
FROM
 orcamentos
 INNER JOIN
 clientes ON clientes.id = orcamentos.cliente_id
 INNER JOIN funcionarios ON funcionarios.id = orcamentos.funcionario_id
 INNER JOIN veiculos ON veiculos.id = orcamentos.veiculo_id;

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
