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

    @excluir-conta-adicionada
    Esquema do Cenario: Excluir conta adicionada
    Quando acessar o menu conta - opção <opcaoMenu>
    Entao deverá encontrar a conta adicionada e excluí-la com sucesso: <conta>
    E ao pesquisa-la não deverá ser listada em tela: <conta>
      Exemplos:
        | opcaoMenu | conta |
        | Listar    | teste |