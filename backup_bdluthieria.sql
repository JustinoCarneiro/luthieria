PGDMP     (         
            |            bdluthieria %   14.12 (Ubuntu 14.12-0ubuntu0.22.04.1) %   14.13 (Ubuntu 14.13-0ubuntu0.22.04.1)     F           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            G           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            H           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            I           1262    16436    bdluthieria    DATABASE     `   CREATE DATABASE bdluthieria WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'pt_BR.UTF-8';
    DROP DATABASE bdluthieria;
                admin    false            �            1259    16438    cliente_pessoa_fisica    TABLE     �  CREATE TABLE public.cliente_pessoa_fisica (
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
 )   DROP TABLE public.cliente_pessoa_fisica;
       public         heap    admin    false            �            1259    16443    cliente_pessoa_juridica    TABLE     (  CREATE TABLE public.cliente_pessoa_juridica (
    id uuid NOT NULL,
    nome_completo character varying(255) NOT NULL,
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
 +   DROP TABLE public.cliente_pessoa_juridica;
       public         heap    admin    false            �            1259    16448    instrumentos_aerofones    TABLE     [  CREATE TABLE public.instrumentos_aerofones (
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
 *   DROP TABLE public.instrumentos_aerofones;
       public         heap    admin    false            �            1259    16453    instrumentos_cordofones    TABLE     H  CREATE TABLE public.instrumentos_cordofones (
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
 +   DROP TABLE public.instrumentos_cordofones;
       public         heap    admin    false            �            1259    16458    instrumentos_idiofones    TABLE     "  CREATE TABLE public.instrumentos_idiofones (
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
 *   DROP TABLE public.instrumentos_idiofones;
       public         heap    admin    false            �            1259    16463    instrumentos_membranofones    TABLE     Y  CREATE TABLE public.instrumentos_membranofones (
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
 .   DROP TABLE public.instrumentos_membranofones;
       public         heap    admin    false            �            1259    16468    ordens_servicos    TABLE     X  CREATE TABLE public.ordens_servicos (
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
 #   DROP TABLE public.ordens_servicos;
       public         heap    admin    false            =          0    16438    cliente_pessoa_fisica 
   TABLE DATA           �   COPY public.cliente_pessoa_fisica (id, nome_completo, data_nascimento, telefone_celular, email, endereco, numero_local, complemento, bairro, cidade, estado, cpf) FROM stdin;
    public          admin    false    209   P4       >          0    16443    cliente_pessoa_juridica 
   TABLE DATA           �   COPY public.cliente_pessoa_juridica (id, nome_completo, telefone_celular, email, endereco, numero_local, complemento, bairro, cidade, estado, razao_social, inscricao_estadual, cnpj) FROM stdin;
    public          admin    false    210   m4       ?          0    16448    instrumentos_aerofones 
   TABLE DATA           g  COPY public.instrumentos_aerofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, tipo_de_bocal, metodo_de_producao_de_som, ajuste_de_afinacao, modelo) FROM stdin;
    public          admin    false    211   *5       @          0    16453    instrumentos_cordofones 
   TABLE DATA           c  COPY public.instrumentos_cordofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, numero_de_cordas, tipo_de_cordas, metodo_execucao_corda, modelo) FROM stdin;
    public          admin    false    212   *6       A          0    16458    instrumentos_idiofones 
   TABLE DATA           I  COPY public.instrumentos_idiofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, metodo_execucao, tipo_idiofone, modelo) FROM stdin;
    public          admin    false    213   �6       B          0    16463    instrumentos_membranofones 
   TABLE DATA           e  COPY public.instrumentos_membranofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, tipo_membrana, metodo_tocar_membrana, ajuste_de_tensao, modelo) FROM stdin;
    public          admin    false    214   �7       C          0    16468    ordens_servicos 
   TABLE DATA           �   COPY public.ordens_servicos (id, codigo, tipo_servico, id_instrumento, id_cliente, valor_servico, pecas, status_instrumento, observacao_status, previsao_entrega) FROM stdin;
    public          admin    false    215   �8       �           2606    16474 3   cliente_pessoa_fisica cliente_pessoa_fisica_cpf_key 
   CONSTRAINT     m   ALTER TABLE ONLY public.cliente_pessoa_fisica
    ADD CONSTRAINT cliente_pessoa_fisica_cpf_key UNIQUE (cpf);
 ]   ALTER TABLE ONLY public.cliente_pessoa_fisica DROP CONSTRAINT cliente_pessoa_fisica_cpf_key;
       public            admin    false    209            �           2606    16476 0   cliente_pessoa_fisica cliente_pessoa_fisica_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.cliente_pessoa_fisica
    ADD CONSTRAINT cliente_pessoa_fisica_pkey PRIMARY KEY (id);
 Z   ALTER TABLE ONLY public.cliente_pessoa_fisica DROP CONSTRAINT cliente_pessoa_fisica_pkey;
       public            admin    false    209            �           2606    16478 8   cliente_pessoa_juridica cliente_pessoa_juridica_cnpj_key 
   CONSTRAINT     s   ALTER TABLE ONLY public.cliente_pessoa_juridica
    ADD CONSTRAINT cliente_pessoa_juridica_cnpj_key UNIQUE (cnpj);
 b   ALTER TABLE ONLY public.cliente_pessoa_juridica DROP CONSTRAINT cliente_pessoa_juridica_cnpj_key;
       public            admin    false    210            �           2606    16480 4   cliente_pessoa_juridica cliente_pessoa_juridica_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.cliente_pessoa_juridica
    ADD CONSTRAINT cliente_pessoa_juridica_pkey PRIMARY KEY (id);
 ^   ALTER TABLE ONLY public.cliente_pessoa_juridica DROP CONSTRAINT cliente_pessoa_juridica_pkey;
       public            admin    false    210            �           2606    16482 2   instrumentos_aerofones instrumentos_aerofones_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.instrumentos_aerofones
    ADD CONSTRAINT instrumentos_aerofones_pkey PRIMARY KEY (id);
 \   ALTER TABLE ONLY public.instrumentos_aerofones DROP CONSTRAINT instrumentos_aerofones_pkey;
       public            admin    false    211            �           2606    16484 4   instrumentos_cordofones instrumentos_cordofones_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.instrumentos_cordofones
    ADD CONSTRAINT instrumentos_cordofones_pkey PRIMARY KEY (id);
 ^   ALTER TABLE ONLY public.instrumentos_cordofones DROP CONSTRAINT instrumentos_cordofones_pkey;
       public            admin    false    212            �           2606    16486 2   instrumentos_idiofones instrumentos_idiofones_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.instrumentos_idiofones
    ADD CONSTRAINT instrumentos_idiofones_pkey PRIMARY KEY (id);
 \   ALTER TABLE ONLY public.instrumentos_idiofones DROP CONSTRAINT instrumentos_idiofones_pkey;
       public            admin    false    213            �           2606    16488 :   instrumentos_membranofones instrumentos_membranofones_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.instrumentos_membranofones
    ADD CONSTRAINT instrumentos_membranofones_pkey PRIMARY KEY (id);
 d   ALTER TABLE ONLY public.instrumentos_membranofones DROP CONSTRAINT instrumentos_membranofones_pkey;
       public            admin    false    214            �           2606    16490 #   ordens_servicos ordens_servico_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.ordens_servicos
    ADD CONSTRAINT ordens_servico_pkey PRIMARY KEY (id);
 M   ALTER TABLE ONLY public.ordens_servicos DROP CONSTRAINT ordens_servico_pkey;
       public            admin    false    215            =      x������ � �      >   �   x�=�K� ��p
. �!�>⮫���01Q1h����Qz��6av�̗�F��sG{�{*��5�P���A�$j�5�H��:Er�= �#���{<���\�����I�4�`b�
�aL)�Ɣ�dӇ��>���󎤋n���\�L*�LcY�/�`�TL�搑Sk�a����BC      ?   �   x��PIj1<��B���,Q�v�!��՗֨2Ҵ�b�<)�|H�@ס�誢�ѣ�E�rr�P�g��r�ڬ��ՊNkA����;�	���j����5���$2�C�d���	Mj�VH?(��8�x���=悖�y�h*�;�0��g��LQDL+f�on��.	�|��1���AX��0�cBW3�G;��\"[
,�nVj������NjkP�'����������r=��      @   �   x�E�1n!D뿧�D�xwe��cK)�&R�m>𑑀o9��r_,4I�if�hf���g���ѡ���(��f�frC�{�o��Ζ'���xM��5R�,�Z�� ,	�zX@�J�~j���h�$�w����o����R��m��}FP0�����FQD̦}��`���8�Y�m "[
,T�<u]��L)      A   �   x�E�AN1EמS��ҙ	�mAE�6��&�=U�$���� �2#�${���3�G�8Ϛ$=Ro�D�z��;�;kw�5��3]� pz�#y�%1�gW|�c*5/�S���E���q)e��M?h�m�#UV�w��V�[���ѿz(Ց������0�v����(��QE���W�&���� JT������=�8��v�M�u�hyT�      B   �   x�E�AN�0E��)r��ڦ�fɌ�l`97q�Hq<���{p�2#H���������];�Ŵ�պ5z�֘{=f\L?��,	N/�L<'��H$�'�>�S�%�L���5{�A9RgJv���%�
+�m"�е}_qN5���9ȍy�����:�[��A�$�C����g�,�J�&����,n6=c�=�J���R�JJ�)7]`qD��i�4�7t`_�      C   �   x�M�;�1 k�]X��������+�S� A�f�h;�`����Z#���l�1�K�*�xF�=ˊd�*#�H	fP�������,a8G��P��҆�Y��.����a������pB�k"����1ȩ �+��s׆6D~�Zy��K���ށzM��3xM�v�ò�h�8���^�CЬ�9{O�B��&_��=�F���u��UQ�     