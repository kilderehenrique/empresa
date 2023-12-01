# Projeto Empresa Ω

## Dump

Na pasta Dump encontra-se os arquivos .sql do bando de dados e o diagrama do bando em .pdf.

## Webapp

Na pasta webapp encontram-se:
    - index.html: Responsavel pelo menu inicial
    - pages: Contem as paginas de listagem e formularios de edição e criação.
    - resources: Contem os icones usados e os arquivos .js
    - web.xml: Está configurado apenas a welcome home page

## Java

No pacote com.empresa encontram-se as pastas:
    - models: Com os modelos das tabelas do banco
    - repository: Com repositorios que realizam a consulta
    - controllers: Com o mapeamento dos end-points que realizam solicitacoes aos repositorios
    - DTO (Data Transfer Object): Classes usadas para conversão e apresentação das respostas em JSON

### Funcionario Controller

End-Points:
    - GET: /funcionarios/
        - Lista funcionários
    - GET: /funcionarios/{id}
        - Busca funcionário
    - POST: /funcionarios/
        - Cadastra funcionário
    - DELETE: /funcionarios/{id}
        - Deleta funcionário

### Loja Controller

End-Points:
    - GET: /lojas/
        - Lista lojas
    - GET: /lojas/{id}
        - Busca loja
    - GET: /lojas/{id}/funcionarios
        - Apresenta informações da loja e lista funcionários da loja
    - POST: /lojas/
        - Cadastra loja
    - DELETE: /lojas/{id}
        - Deleta lojas
