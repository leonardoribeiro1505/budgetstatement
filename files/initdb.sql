CREATE DATABASE spring_batch;
CREATE DATABASE app;

USE app;

CREATE TABLE launch (
    codeExpense INT,
    descriptionExpense TEXT,
    descriptionLaunch TEXT,
    dateLaunch DATE,
    amountLaunch DOUBLE
);

INSERT INTO launch (codeExpense, descriptionExpense, descriptionLaunch, dateLaunch, amountLaunch)
VALUES
    (44905224,'EQUIPAMENTO DE PROTEÇÃO SEGURANÇA E SOCORRO','Alarme','2020-05-01',1000),
    (44905287,'MATERIAL DE CONSUMO DE USO DURADOURO','Cortina de sala','2020-05-02',1000),
    (44905287,'MATERIAL DE CONSUMO DE USO DURADOURO','Bandeiras','2020-05-03',500),
    (44905287,'MATERIAL DE CONSUMO DE USO DURADOURO','Guarda Sol','2020-05-04',500),
    (33903016,'MATERIAL DE EXPEDIENTE','Resma de Papel A4','2020-05-01',2000),
    (33903016,'MATERIAL DE EXPEDIENTE','Cartucho Impressora','2020-05-10',2000),
    (44905218,'COLEÇÕES E MATERIAIS BIBLIOGRÁFICOS','Dicionários','2020-05-12',4000),
    (44905218,'COLEÇÕES E MATERIAIS BIBLIOGRÁFICOS','Livro de Algoritmos','2020-05-11',4000),
    (33903024,'MATERIAL P/ MANUT. DE BENS IMÓVEIS/INSTALAÇÕES','Amianto','2020-05-13',8000),
    (33903024,'MATERIAL P/ MANUT. DE BENS IMÓVEIS/INSTALAÇÕES','Aparelhos Sanitários','2020-05-11',6000),
    (33903024,'MATERIAL P/ MANUT. DE BENS IMÓVEIS/INSTALAÇÕES','Cimento','2020-05-12',2000),
    (33903302,'PASSAGENS PARA O EXTERIOR','Viagem para Las Vegas','2020-05-01',32000);