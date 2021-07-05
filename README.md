# DivulgaTudo
Desafio de Programação - Academia Capgemini


PASSO 1 - CRIAR TABELA NO BANCO

CREATE TABLE public.tb_anuncio( id numeric (3) NOT NULL, "nomeDoAnuncio" varchar (50)NOT NULL, "cliente" varchar (50) NOT NULL, "dataDeInicio" date NOT NULL, "dataDeTermino" date NOT NULL, investimentoPorDia numeric (8,2) NOT NULL, valorTotalInvestido numeric (8,2), quantidadeMaximaDeVisualizacoes numeric (10), quantidadeMaximaDeCliques numeric (10), quantidadeMaximaDeCompartilhamentos numeric (10), CONSTRAINT tb_anuncio_pkey PRIMARY KEY (id) );

PASSO 2 - START NO BACK

PASSO 3 - USAR O FRONT
