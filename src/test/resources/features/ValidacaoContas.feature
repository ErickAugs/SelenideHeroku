# language: pt
Funcionalidade: Adicionar ou excluir conta

  Contexto:
    Dado que esteja logado na pagina do seu barriga

  @incluir-conta
  Esquema do Cenario: Adicionar nova conta
    Quando acessar o menu conta - opção <opcaoMenu>
    E digitar o nome da nova conta: <conta>
    Então deverá ser incluída com sucesso: <conta>
    Exemplos:
      | opcaoMenu | conta |
      | Adicionar | teste |