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
    nome_completo character varying(255),
    data_nascimento date,
    telefone_celular character varying(20),
    email character varying(255),
    endereco character varying(255),
    numero_local character varying(10),
    complemento character varying(255),
    bairro character varying(100),
    cidade character varying(100),
    estado character varying(50),
    cpf character varying(20)
);


ALTER TABLE public.cliente_pessoa_fisica OWNER TO admin;

--
-- Name: cliente_pessoa_juridica; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.cliente_pessoa_juridica (
    id uuid NOT NULL,
    nome_completo character varying(255),
    data_nascimento date,
    telefone_celular character varying(20),
    email character varying(255),
    endereco character varying(255),
    numero_local character varying(10),
    complemento character varying(255),
    bairro character varying(100),
    cidade character varying(100),
    estado character varying(50),
    razao_social character varying(255),
    inscricao_estadual character varying(50),
    cnpj character varying(20)
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
    procedencia text,
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
    ajuste_de_afinacao character varying(255)
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
    procedencia text,
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
    metodo_execucao_corda character varying(255)
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
    procedencia text,
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
    tipo_idiofone character varying(255)
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
    procedencia text,
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
    ajuste_de_tensao character varying(255)
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
85b2cc06-9bd7-4d0f-95b4-1f54fdac9018	João da Silva	1990-01-01	987654321	joao@example.com	Rua Exemplo	123	Apto 101	Bairro Exemplo	Cidade Exemplo	Estado Exemplo	123.456.789-00
\.


--
-- Data for Name: cliente_pessoa_juridica; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.cliente_pessoa_juridica (id, nome_completo, data_nascimento, telefone_celular, email, endereco, numero_local, complemento, bairro, cidade, estado, razao_social, inscricao_estadual, cnpj) FROM stdin;
e41d001c-6468-4631-812f-7bfeb623c318	Empresa Exemplo Ltda	2000-01-01	987654321	contato@empresa.com	Avenida Exemplo	456	Sala 202	Bairro Exemplo	Cidade Exemplo	Estado Exemplo	Razão Social Exemplo	123.456.789.000	12.345.678/0001-99
\.


--
-- Data for Name: instrumentos_aerofones; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.instrumentos_aerofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, tipo_de_bocal, metodo_de_producao_de_som, ajuste_de_afinacao) FROM stdin;
4854604b-fcb9-4adb-b328-c26fa9a807c0	Flauta	\N	Aerofone	Brasil	Instrumento musical de sopro	2021-08-08	Fabricante Exemplo	Brasil	Cidade Exemplo	Estado Exemplo	\N	Bambu	0.2	0.5	Ótimo	Sem marcas	Ativo	Bocal transversal	Sopro direto	Parafusos de ajuste
13f608ed-40d3-4d3d-9cb2-b49131bcfd86	Flauta	\N	Aerofone	Brasil	Instrumento musical de sopro	2021-08-08	Fabricante Exemplo	Brasil	Cidade Exemplo	Estado Exemplo	\N	Bambu	0.2	0.5	Ótimo	Sem marcas	Ativo	Bocal transversal	Sopro direto	Parafusos de ajuste
0c22a280-668f-4aa8-9c11-13051428f509	Flauta	\N	Aerofone	Brasil	Instrumento musical de sopro	2021-08-08	Fabricante Exemplo	Brasil	Cidade Exemplo	Estado Exemplo	\N	Bambu	0.2	0.5	Ótimo	Sem marcas	Ativo	Bocal transversal	Sopro direto	Parafusos de ajuste
\.


--
-- Data for Name: instrumentos_cordofones; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.instrumentos_cordofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, numero_de_cordas, tipo_de_cordas, metodo_execucao_corda) FROM stdin;
9f9b6cb8-b886-4159-8eee-f8c1e089d734	Violão	\N	Cordofone	Brasil	Instrumento musical de cordas	2022-05-05	Fabricante Exemplo	Brasil	Cidade Exemplo	Estado Exemplo	\N	Madeira	2	1	Ótimo	Sem marcas	Ativo	6	Nylon	Dedilhado
accc9931-f7e7-418d-860e-8b89644bffa6	Violão	\N	Cordofone	Brasil	Instrumento musical de cordas	2022-05-05	Fabricante Exemplo	Brasil	Cidade Exemplo	Estado Exemplo	\N	Madeira	2	1	Ótimo	Sem marcas	Ativo	6	Nylon	Dedilhado
d3d19cb9-03f9-4590-9309-6267839b6348	Violão	\N	Cordofone	Brasil	Instrumento musical de cordas	2022-05-05	Fabricante Exemplo	Brasil	Cidade Exemplo	Estado Exemplo	\N	Madeira	2	1	Ótimo	Sem marcas	Ativo	6	Nylon	Dedilhado
\.


--
-- Data for Name: instrumentos_idiofones; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.instrumentos_idiofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, metodo_execucao, tipo_idiofone) FROM stdin;
198af874-012a-4be5-9d07-1fb3f7395fc6	Triângulo	\N	Idiofone	Brasil	Instrumento musical de percussão	2023-01-01	Fabricante Exemplo	Brasil	Cidade Exemplo	Estado Exemplo	\N	Metal	0.5	0.3	Ótimo	Sem marcas	Ativo	Agitado com as mãos	Metalofone
58a07564-bcbd-433c-b880-8206ffcdeeda	Triângulo	\N	Idiofone	Brasil	Instrumento musical de percussão	2023-01-01	Fabricante Exemplo	Brasil	Cidade Exemplo	Estado Exemplo	\N	Metal	0.5	0.3	Ótimo	Sem marcas	Ativo	Agitado com as mãos	Metalofone
9140e59f-175c-4dfc-a259-d7859752436d	Triângulo	\N	Idiofone	Brasil	Instrumento musical de percussão	2023-01-01	Fabricante Exemplo	Brasil	Cidade Exemplo	Estado Exemplo	\N	Metal	0.5	0.3	Ótimo	Sem marcas	Ativo	Agitado com as mãos	Metalofone
\.


--
-- Data for Name: instrumentos_membranofones; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.instrumentos_membranofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, tipo_membrana, metodo_tocar_membrana, ajuste_de_tensao) FROM stdin;
3e108c6c-e552-4558-a4e0-7677ab303e08	Tambor	\N	Membranofone	Brasil	Instrumento musical de percussão com membrana	2020-11-11	Fabricante Exemplo	Brasil	Cidade Exemplo	Estado Exemplo	\N	Couro	1	0.6	Ótimo	Sem marcas	Ativo	Membrana de animal	Batida com baqueta	Cordas de tensão
8391a5ab-7db0-4177-8423-d936eea62ca8	Tambor	\N	Membranofone	Brasil	Instrumento musical de percussão com membrana	2020-11-11	Fabricante Exemplo	Brasil	Cidade Exemplo	Estado Exemplo	\N	Couro	1	0.6	Ótimo	Sem marcas	Ativo	Membrana de animal	Batida com baqueta	Cordas de tensão
b06dca41-3c7b-4c26-9d87-ebe997413bd4	Tambor	\N	Membranofone	Brasil	Instrumento musical de percussão com membrana	2020-11-11	Fabricante Exemplo	Brasil	Cidade Exemplo	Estado Exemplo	\N	Couro	1	0.6	Ótimo	Sem marcas	Ativo	Membrana de animal	Batida com baqueta	Cordas de tensão
\.


--
-- Data for Name: ordens_servicos; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.ordens_servicos (id, codigo, tipo_servico, id_instrumento, id_cliente, valor_servico, pecas, status_instrumento, observacao_status, previsao_entrega) FROM stdin;
27460aa0-b090-429b-9319-953346a3baaa	20240900001	Conserto	ac8332d0-47e1-4b37-8da4-c1f7c8739ee0	e585ab04-abcf-45ed-aede-0b30e6c939e0	500.00	Troca de peças	Em andamento	Descrição do status	2024-09-25
20feae03-fe74-4f1c-820c-ccb0c01e02b4	20240900002	Conserto	ff991c2b-38c0-41e0-b71f-69dfc76afcf4	8fabf279-342b-4116-b5cd-5ad0bcbb14f3	500.00	Troca de peças	Em andamento	Descrição do status	2024-09-25
\.


--
-- Name: cliente_pessoa_fisica cliente_pessoa_fisica_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.cliente_pessoa_fisica
    ADD CONSTRAINT cliente_pessoa_fisica_pkey PRIMARY KEY (id);


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

