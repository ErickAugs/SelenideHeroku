# language: pt
  @todos
  Funcionalidade: Login de acesso a pagina Seu barriga

    Contexto:
      Dado que esteja logado na pagina do seu barriga

     @acessarSeuMadruga
      Cenario: acessar pagina de login
        Quando acessar a pagina e capturar o nome
        Então o nome estará Bem vindo, Xiaomi!