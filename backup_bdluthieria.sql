--
-- PostgreSQL database dump
--

-- Dumped from database version 16.4 (Debian 16.4-1.pgdg120+1)
-- Dumped by pg_dump version 16.4 (Debian 16.4-1.pgdg120+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: cliente_pessoa_fisica; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.cliente_pessoa_fisica (
    id uuid NOT NULL,
    nome_completo character varying(255) NOT NULL,
    data_nascimento date,
    telefone_celular character varying(255),
    email character varying(255),
    endereco character varying(255),
    numero_local character varying(10),
    complemento character varying(255),
    bairro character varying(255),
    cidade character varying(255),
    estado character varying(255),
    cpf character varying(255) NOT NULL
);


ALTER TABLE public.cliente_pessoa_fisica OWNER TO admin;

--
-- Name: cliente_pessoa_juridica; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.cliente_pessoa_juridica (
    id uuid NOT NULL,
    nome_completo character varying(255) NOT NULL,
    data_nascimento date,
    telefone_celular character varying(255),
    email character varying(255),
    endereco character varying(255),
    numero_local character varying(10),
    complemento character varying(255),
    bairro character varying(255),
    cidade character varying(255),
    estado character varying(255),
    razao_social character varying(255),
    inscricao_estadual character varying(255),
    cnpj character varying(255) NOT NULL
);


ALTER TABLE public.cliente_pessoa_juridica OWNER TO admin;

--
-- Name: instrumentos_aerofones; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.instrumentos_aerofones (
    id uuid NOT NULL,
    nome character varying(255),
    nomes_adicionais text,
    categoria character varying(255),
    procedencia character varying(255),
    descricao text,
    data_fabricacao date,
    fabricante character varying(255),
    fabricacao_pais character varying(255),
    fabricacao_cidade character varying(255),
    fabricacao_estado character varying(255),
    fabricacao_localidade character varying(255),
    material character varying(255),
    peso double precision,
    altura double precision,
    estado_conservacao character varying(255),
    marcas_inscricoes text,
    status character varying(255),
    tipo_de_bocal character varying(255),
    metodo_de_producao_de_som character varying(255),
    ajuste_de_afinacao character varying(255),
    modelo character varying(255)
);


ALTER TABLE public.instrumentos_aerofones OWNER TO admin;

--
-- Name: instrumentos_cordofones; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.instrumentos_cordofones (
    id uuid NOT NULL,
    nome character varying(255),
    nomes_adicionais text,
    categoria character varying(255),
    procedencia character varying(255),
    descricao text,
    data_fabricacao date,
    fabricante character varying(255),
    fabricacao_pais character varying(255),
    fabricacao_cidade character varying(255),
    fabricacao_estado character varying(255),
    fabricacao_localidade character varying(255),
    material character varying(255),
    peso double precision,
    altura double precision,
    estado_conservacao character varying(255),
    marcas_inscricoes text,
    status character varying(255),
    numero_de_cordas integer,
    tipo_de_cordas character varying(255),
    metodo_execucao_corda character varying(255),
    modelo character varying(255)
);


ALTER TABLE public.instrumentos_cordofones OWNER TO admin;

--
-- Name: instrumentos_idiofones; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.instrumentos_idiofones (
    id uuid NOT NULL,
    nome character varying(255),
    nomes_adicionais text,
    categoria character varying(255),
    procedencia character varying(255),
    descricao text,
    data_fabricacao date,
    fabricante character varying(255),
    fabricacao_pais character varying(255),
    fabricacao_cidade character varying(255),
    fabricacao_estado character varying(255),
    fabricacao_localidade character varying(255),
    material character varying(255),
    peso double precision,
    altura double precision,
    estado_conservacao character varying(255),
    marcas_inscricoes text,
    status character varying(255),
    metodo_execucao character varying(255),
    tipo_idiofone character varying(255),
    modelo character varying(255)
);


ALTER TABLE public.instrumentos_idiofones OWNER TO admin;

--
-- Name: instrumentos_membranofones; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.instrumentos_membranofones (
    id uuid NOT NULL,
    nome character varying(255),
    nomes_adicionais text,
    categoria character varying(255),
    procedencia character varying(255),
    descricao text,
    data_fabricacao date,
    fabricante character varying(255),
    fabricacao_pais character varying(255),
    fabricacao_cidade character varying(255),
    fabricacao_estado character varying(255),
    fabricacao_localidade character varying(255),
    material character varying(255),
    peso double precision,
    altura double precision,
    estado_conservacao character varying(255),
    marcas_inscricoes text,
    status character varying(255),
    tipo_membrana character varying(255),
    metodo_tocar_membrana character varying(255),
    ajuste_de_tensao character varying(255),
    modelo character varying(255)
);


ALTER TABLE public.instrumentos_membranofones OWNER TO admin;

--
-- Name: ordens_servicos; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.ordens_servicos (
    id uuid NOT NULL,
    codigo character varying(255) NOT NULL,
    tipo_servico character varying(255),
    id_instrumento uuid,
    id_cliente uuid,
    valor_servico numeric(10,2),
    pecas text,
    status_instrumento character varying(255),
    observacao_status text,
    previsao_entrega date
);


ALTER TABLE public.ordens_servicos OWNER TO admin;

--
-- Data for Name: cliente_pessoa_fisica; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.cliente_pessoa_fisica (id, nome_completo, data_nascimento, telefone_celular, email, endereco, numero_local, complemento, bairro, cidade, estado, cpf) FROM stdin;
2690581e-3688-4c55-a555-29a1ea5530e9	João da Silva	1990-01-01	987654321	joao@example.com	Rua Exemplo	123	Apto 101	Bairro Exemplo	Cidade Exemplo	Estado Exemplo	123.456.789-00
\.


--
-- Data for Name: cliente_pessoa_juridica; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.cliente_pessoa_juridica (id, nome_completo, data_nascimento, telefone_celular, email, endereco, numero_local, complemento, bairro, cidade, estado, razao_social, inscricao_estadual, cnpj) FROM stdin;
475ebd1c-b11b-4fed-9747-182963f66fa4	Empresa Exemplo Ltda	2000-01-01	987654321	contato@empresa.com	Avenida Exemplo	456	Sala 202	Bairro Exemplo	Cidade Exemplo	Estado Exemplo	Razão Social Exemplo	123.456.789.000	12.345.678/0001-99
\.


--
-- Data for Name: instrumentos_aerofones; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.instrumentos_aerofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, tipo_de_bocal, metodo_de_producao_de_som, ajuste_de_afinacao, modelo) FROM stdin;
fb83f066-162f-44a2-9fc0-3d8bc5202caf	Flauta	\N	Aerofone	Brasil	Instrumento musical de sopro	2021-08-08	Fabricante Exemplo	Brasil	Cidade Exemplo	Estado Exemplo	\N	Bambu	0.2	0.5	Ótimo	Sem marcas	Ativo	Bocal transversal	Sopro direto	Parafusos de ajuste	modelo 3
\.


--
-- Data for Name: instrumentos_cordofones; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.instrumentos_cordofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, numero_de_cordas, tipo_de_cordas, metodo_execucao_corda, modelo) FROM stdin;
\.


--
-- Data for Name: instrumentos_idiofones; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.instrumentos_idiofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, metodo_execucao, tipo_idiofone, modelo) FROM stdin;
\.


--
-- Data for Name: instrumentos_membranofones; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.instrumentos_membranofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, tipo_membrana, metodo_tocar_membrana, ajuste_de_tensao, modelo) FROM stdin;
\.


--
-- Data for Name: ordens_servicos; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.ordens_servicos (id, codigo, tipo_servico, id_instrumento, id_cliente, valor_servico, pecas, status_instrumento, observacao_status, previsao_entrega) FROM stdin;
ed5b6154-7225-4717-8bfd-a86d93c29f21	20240900003	Conserto	fb83f066-162f-44a2-9fc0-3d8bc5202caf	2690581e-3688-4c55-a555-29a1ea5530e9	500.00	Troca de peças	Em andamento	Descrição do status	2024-09-26
\.


--
-- Name: cliente_pessoa_fisica cliente_pessoa_fisica_cpf_key; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.cliente_pessoa_fisica
    ADD CONSTRAINT cliente_pessoa_fisica_cpf_key UNIQUE (cpf);


--
-- Name: cliente_pessoa_fisica cliente_pessoa_fisica_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.cliente_pessoa_fisica
    ADD CONSTRAINT cliente_pessoa_fisica_pkey PRIMARY KEY (id);


--
-- Name: cliente_pessoa_juridica cliente_pessoa_juridica_cnpj_key; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.cliente_pessoa_juridica
    ADD CONSTRAINT cliente_pessoa_juridica_cnpj_key UNIQUE (cnpj);


--
-- Name: cliente_pessoa_juridica cliente_pessoa_juridica_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.cliente_pessoa_juridica
    ADD CONSTRAINT cliente_pessoa_juridica_pkey PRIMARY KEY (id);


--
-- Name: instrumentos_aerofones instrumentos_aerofones_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.instrumentos_aerofones
    ADD CONSTRAINT instrumentos_aerofones_pkey PRIMARY KEY (id);


--
-- Name: instrumentos_cordofones instrumentos_cordofones_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.instrumentos_cordofones
    ADD CONSTRAINT instrumentos_cordofones_pkey PRIMARY KEY (id);


--
-- Name: instrumentos_idiofones instrumentos_idiofones_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.instrumentos_idiofones
    ADD CONSTRAINT instrumentos_idiofones_pkey PRIMARY KEY (id);


--
-- Name: instrumentos_membranofones instrumentos_membranofones_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.instrumentos_membranofones
    ADD CONSTRAINT instrumentos_membranofones_pkey PRIMARY KEY (id);


--
-- Name: ordens_servicos ordens_servico_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.ordens_servicos
    ADD CONSTRAINT ordens_servico_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

