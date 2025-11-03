-- V2: Migrations for add the column rank in tb_cadastro

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);