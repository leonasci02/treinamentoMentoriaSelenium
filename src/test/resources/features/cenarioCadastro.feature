# language: pt
Funcionalidade: Cadastro de cliente
  
  Como usuário gostaria de realizar o cadastro no site automationPratice como um novo cliente

  @cucumberTest
  Cenário: Cadastro com successo
    Dado que acesse o e-commerce
    E opto por selecionar SignIn
    E preencher um novo email
    Quando selecionar create an account
    E opto por preencher os campos de cadastro
    Então o sistema deve realizar o cadastro com sucesso

  @cucumberTest1
  Cenário: Cadastro com successo
    Dado que acesse o e-commerce
    E opto por selecionar o menu "Dresses" -> "Casual Dresses"
    Quando apresentar a tela do menu 
    Então o sistema mostrará os itens
    
  @cucumberTest    
 Cenário: consultar endereço cadastrados
    Dado que acesse o e-commerce
    E opto por selecionar SignIn
    Quando preencher o email e senha
    E opto por selecionar a opção "My Address"
    Então o sistema apresenta as informações de endereço cadastrado