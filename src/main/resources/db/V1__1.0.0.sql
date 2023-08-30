CREATE
DATABASE springbackend WITH OWNER = springbackend TABLESPACE = pg_default TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'pt_BR.UTF-8' LC_CTYPE = 'pt_BR.UTF-8' CONNECTION LIMIT = -1;

-- Criar schema e extensão no banco 'springbackend'

\connect
springbackend

CREATE SCHEMA springbackend AUTHORIZATION springbackend;

GRANT
ALL
ON SCHEMA springbackend TO springbackend WITH GRANT OPTION;

CREATE
EXTENSION unaccent SCHEMA lean;

-- Criar a tabela pessoa
CREATE TABLE pessoa
(
    id   SERIAL PRIMARY KEY,
    nome VARCHAR(100)
);