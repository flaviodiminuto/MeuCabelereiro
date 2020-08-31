#language: pt
  Funcionalidade: Cadastro de usuario
    Endpoint para o cadastro de novo usuario para a aplicacao MeuCabelereiro

###############      CADASTRAR USUARIO  ###############################
    @cadastrar
    @cadastrar_fluxo_otimo
    Cenario: Cadastrar novo usuário (fluxo otimo)
      Dado que eu preencha o campo login com o valor "flaviodiminuto"
      E preencha o campo senha com o valor "valor-senha"
      E preencher o campo confirmar senha com o valor "valor-senha"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 201


    @cadastrar
    @cadastrar_usuario_existente
    Cenario: Tentar cadastrar usuário já existente
      Dado que eu preencha o campo login com o valor "flaviodiminuto"
      E preencha o campo senha com o valor "valor-senha"
      E preencher o campo confirmar senha com o valor "valor-senha"
      E enviar a requisicao para cadastrar novo usuario
      #Preencher novamente os mesmos dados
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 401

    @cadastrar
    @cadastrar_confirmar_senha_diferente
    Cenario: Tentar cadastrar senha e confirmacao diferentes
      Dado que eu preencha o campo login com o valor "valorlogin1"
      E preencha o campo senha com o valor "valor-senha"
      E preencher o campo confirmar senha com o valor "valor-88888"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 400

    @cadastrar
    @adastrar_com_login_em_branco
    Cenario: Tentar cadastrar com login em branco
      Dado que eu preencha o campo login com o valor ""
      E preencha o campo senha com o valor "valor-senha"
      E preencher o campo confirmar senha com o valor "valor-88888"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 400

    @cadastrar
    @cadastrar_senha_em_branco
    Cenario: Tentar cadastrar usuario com a senha em branco
      Dado que eu preencha o campo login com o valor "valorlogin1"
      E preencha o campo senha com o valor ""
      E preencher o campo confirmar senha com o valor "valor-senha"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 400

    @cadastrar
    @cadastrar_confirma_senha_em_branco
    Cenario: Tentar cadastrar usuario com a confirmacao da senha em branco
      Dado que eu preencha o campo login com o valor "valorlogin1"
      E preencha o campo senha com o valor "valor-senha"
      E preencher o campo confirmar senha com o valor ""
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 400

    @cadastrar
    @cadastrar_login_e_senha_em_branco
    Cenario: Tentar cadastrar usuario com a confirmacao da senha em branco
      Dado que eu preencha o campo login com o valor ""
      E preencha o campo senha com o valor ""
      E preencher o campo confirmar senha com o valor "valor-senha"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 400

    @cadastrar
    @cadastrar_login_e_senha_em_branco
    Cenario: Tentar cadastrar usuario com a confirmacao da senha em branco
      Dado que eu preencha o campo login com o valor "valorlogin1"
      E preencha o campo senha com o valor "valor88"
      E preencher o campo confirmar senha com o valor "valor88"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 400

    @cadastrar
    @cadastrar_todos_parametros_em_branco
    Cenario: Tentar cadastrar novo usuario passando todos os parametros em branco
      Dado que eu preencha o campo login com o valor ""
      E preencha o campo senha com o valor ""
      E preencher o campo confirmar senha com o valor ""
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 400