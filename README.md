# App Leilão

### Configuração do Banco de dados
- Na raiz do projeto se encontram os seguintes arquivos:
  - docker-compose.yml
  - variables.env
- Eles serão responsáveis pela conexão com banco
- Em um ambiente linux, execute o comando abaixo para iniciar o banco:
```shell
docker-compose up -d
```
- Após executado, o banco estará disponível para conexão e os scripts de DDL e DML foram executados
- Verifique o arquuivo <b>variables.env</b> para conectar corretemente ao banco

<hr>

### Configuração do Back End
- Abra a pasta <b>leilao-api</b> em sua IDE e executar o arquivo <b>LeilaoApplication</b>


<hr>

### Configuração do Front End
- Vá para a pasta <b>leilao-app</b>
- Utilize o node na verão: <b>12.22.5</b>
- Execute o comando npm install
- Em seguida, execute npm run dev

<hr>

Pronto! A aplicação estará disponível em:
```
http://localhost:8080/
```