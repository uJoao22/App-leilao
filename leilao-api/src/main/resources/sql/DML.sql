-- Inserindo dados na tabela 'endereco'
INSERT INTO endereco
(logradouro, municipio, numero, complemento, bairro, cep)
VALUES
('Rua das Flores', 'São Paulo', '100', 'Apt 1', 'Centro', '01000-000'),
('Av. Paulista', 'São Paulo', '200', 'Sala 25', 'Bela Vista', '01310-000'),
('Rua Augusta', 'São Paulo', '300', '', 'Jardins', '01400-000'),
('Rua Consolação', 'São Paulo', '400', '2º Andar', 'Consolação', '01500-000'),
('Av. Faria Lima', 'São Paulo', '500', 'Conj. 101', 'Itaim Bibi', '01600-000'),
('Rua Vergueiro', 'São Paulo', '600', '', 'Vila Mariana', '01700-000'),
('Av. Brigadeiro', 'São Paulo', '700', 'Sala 405', 'Moema', '01800-000'),
('Rua Oscar Freire', 'São Paulo', '800', '', 'Pinheiros', '01900-000'),
('Rua da Consolação', 'São Paulo', '900', 'Bloco B', 'Higienópolis', '02000-000'),
('Av. Ibirapuera', 'São Paulo', '1000', 'Loja 3', 'Moema', '02100-000');

-- Inserindo dados na tabela 'empresa'
INSERT INTO empresa
(razao_social, cnpj, id_endereco, telefone, email, site, usuario, senha)
VALUES
('Empresa Alpha Ltda', '82060868000141', 1, '11987654321', 'contato@alpha.com.br', 'www.alpha.com.br', 'alphaUser', '123456'),
('Beta Comércio', '14841643000172', 2, '11987654322', 'contato@beta.com.br', 'www.beta.com.br', 'betaUser', '123456'),
('Gamma Logística', '34302038000130', 3, '11987654323', 'contato@gamma.com.br', 'www.gamma.com.br', 'gammaUser', '123456'),
('Delta Tech', '56718655000154', 4, '11987654324', 'contato@delta.com.br', 'www.delta.com.br', 'deltaUser', '123456'),
('Epsilon S.A.', '09114954000108', 5, '11987654325', 'contato@epsilon.com.br', 'www.epsilon.com.br', 'epsilonUser', '123456'),
('Zeta Ltda', '66647685000170', 6, '11987654326', 'contato@zeta.com.br', 'www.zeta.com.br', 'zetaUser', '123456'),
('Eta Comércio', '84349748000194', 7, '11987654327', 'contato@eta.com.br', 'www.eta.com.br', 'etaUser', '123456'),
('Theta Soluções', '24199700000115', 8, '11987654328', 'contato@theta.com.br', 'www.theta.com.br', 'thetaUser', '123456'),
('Iota Serviços', '82234648000197', 9, '11987654329', 'contato@iota.com.br', 'www.iota.com.br', 'iotaUser', '123456'),
('Kappa Logística', '46735121000182', 10, '11987654330', 'contato@kappa.com.br', 'www.kappa.com.br', 'kappaUser', '123456');

-- Inserindo dados na tabela 'leilao'
INSERT INTO leilao
(codigo, descricao, vendedor, inicio_previsto)
VALUES
(101, 'Leilão de Eletrônicos', 1, NOW() + INTERVAL '2 days'),
(102, 'Leilão de Veículos', 2, NOW() + INTERVAL '5 days'),
(103, 'Leilão de Imóveis', 3, NOW() + INTERVAL '10 days'),
(104, 'Leilão de Máquinas Industriais', 4, NOW() + INTERVAL '7 days'),
(105, 'Leilão de Equipamentos Médicos', 5, NOW() + INTERVAL '12 days'),
(106, 'Leilão de Ferramentas', 6, NOW() + INTERVAL '3 days'),
(107, 'Leilão de Móveis de Escritório', 7, NOW() + INTERVAL '8 days'),
(108, 'Leilão de Computadores', 8, NOW() + INTERVAL '1 day'),
(109, 'Leilão de Eletrodomésticos', 9, NOW() + INTERVAL '6 days'),
(110, 'Leilão de Motos', 10, NOW() + INTERVAL '9 days');

-- Inserindo dados na tabela 'unidade'
INSERT INTO unidade
(nome)
VALUES
('Unidade de Peso'),
('Unidade de Volume'),
('Unidade de Área'),
('Unidade de Comprimento'),
('Unidade de Tempo'),
('Unidade de Massa'),
('Unidade de Capacidade'),
('Unidade de Frequência'),
('Unidade de Velocidade'),
( 'Unidade de Força');

-- Inserindo dados na tabela 'lote'
INSERT INTO lote
(numero_lote, descricao, quantidade, valor_inicial, unidade, id_leilao)
VALUES
(1001, 'Lote de Smartphones', 50, 5000.00, 'Unidade de Peso', 1),
(1002, 'Lote de Carros', 10, 150000.00, 'Unidade de Volume', 2),
(1003, 'Lote de Apartamentos', 5, 750000.00, 'Unidade de Área', 3),
(1004, 'Lote de Máquinas', 3, 200000.00, 'Unidade de Comprimento', 4),
(1005, 'Lote de Equipamentos', 20, 100000.00, 'Unidade de Tempo', 5),
(1006, 'Lote de Ferramentas', 100, 5000.00, 'Unidade de Massa', 6),
(1007, 'Lote de Móveis', 50, 30000.00, 'Unidade de Capacidade', 7),
(1008, 'Lote de Computadores', 30, 75000.00, 'Unidade de Frequência', 8),
(1009, 'Lote de Eletrodomésticos', 40, 60000.00, 'Unidade de Velocidade', 9),
(1010, 'Lote de Motos', 15, 100000.00, 'Unidade de Força', 10);

-- Inserindo dados na tabela 'comprador'
INSERT INTO comprador
(id_empresa, id_leilao)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);