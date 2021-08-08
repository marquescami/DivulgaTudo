# DivulgaTudo
Desafio de Programação - Academia Capgemini


PASSO 1 - CRIAR TABELA NO BANCO

CREATE TABLE public.tb_anuncio( id numeric (3) NOT NULL, "nomeDoAnuncio" varchar (50)NOT NULL, "cliente" varchar (50) NOT NULL, "dataDeInicio" date NOT NULL, "dataDeTermino" date NOT NULL, investimentoPorDia numeric (8,2) NOT NULL, valorTotalInvestido numeric (8,2), quantidadeMaximaDeVisualizacoes numeric (10), quantidadeMaximaDeCliques numeric (10), quantidadeMaximaDeCompartilhamentos numeric (10), CONSTRAINT tb_anuncio_pkey PRIMARY KEY (id) );

PASSO 2 - START NO BACK

PASSO 3 - USAR O FRONT


Criação de um sistema que permite o cadastro de anúncios. O anúncio deverá conter os seguintes dados:
nome do anúncio
cliente
data de início
data de término
investimento por dia
 
O sistema fornecerá os relatórios de cada anúncio contendo:
valor total investido
quantidade máxima de visualizações
quantidade máxima de cliques
quantidade máxima de compartilhamentos
