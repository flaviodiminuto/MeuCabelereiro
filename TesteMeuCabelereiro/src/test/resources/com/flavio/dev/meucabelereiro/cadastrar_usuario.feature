#language: pt
  Funcionalidade: Cadastro de usuario
    Endpoint para o cadastro de novo usuario para a aplicacao MeuCabelereiro

    @meu_cabelereiro
    @cadastrar_usuario
    @cadastrar_usuario_fluxo_otimo
    Cenario: Cadastrar novo usuário (fluxo otimo)
      Dado que eu preencha o campo login com o valor "flaviodiminuto"
      E preencha o campo senha com o valor "valor-senha"
      E preencher o campo confirmar senha com o valor "valor-senha"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 201

    @meu_cabelereiro
    @cadastrar_usuario
    @cadastrar_usuario_usuario_existente
    Cenario: Tentar cadastrar usuário já existente
      Dado que eu preencha o campo login com o valor "flaviodiminutocad"
      E preencha o campo senha com o valor "valor-senha"
      E preencher o campo confirmar senha com o valor "valor-senha"
      E enviar a requisicao para cadastrar novo usuario
      #Preencher novamente os mesmos dados
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 403

    @meu_cabelereiro
    @cadastrar_usuario
    @cadastrar_usuario_confirmar_senha_diferente
    Cenario: Tentar cadastrar senha e confirmacao diferentes
      Dado que eu preencha o campo login com o valor "valorlogin1"
      E preencha o campo senha com o valor "valor-senha"
      E preencher o campo confirmar senha com o valor "valor-88888"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 400

    @meu_cabelereiro
    @cadastrar_usuario
    @cadastrar_usuario_com_login_em_branco
    Cenario: Tentar cadastrar com login em branco
      Dado que eu preencha o campo login com o valor ""
      E preencha o campo senha com o valor "valor-senha"
      E preencher o campo confirmar senha com o valor "valor-88888"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 400

    @meu_cabelereiro
    @cadastrar_usuario
    @cadastrar_usuario_senha_em_branco
    Cenario: Tentar cadastrar usuario com a senha em branco
      Dado que eu preencha o campo login com o valor "valorlogin1"
      E preencha o campo senha com o valor ""
      E preencher o campo confirmar senha com o valor "valor-senha"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 400

    @meu_cabelereiro
    @cadastrar_usuario
    @cadastrar_usuario_confirma_senha_em_branco
    Cenario: Tentar cadastrar usuario com a confirmacao da senha em branco
      Dado que eu preencha o campo login com o valor "valorlogin1"
      E preencha o campo senha com o valor "valor-senha"
      E preencher o campo confirmar senha com o valor ""
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 400

    @meu_cabelereiro
    @cadastrar_usuario
    @cadastrar_usuario_login_e_senha_em_branco
    Cenario: Tentar cadastrar usuario com login e senha em branco
      Dado que eu preencha o campo login com o valor ""
      E preencha o campo senha com o valor ""
      E preencher o campo confirmar senha com o valor "valor-senha"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 400

    @meu_cabelereiro
    @cadastrar_usuario
    @cadastrar_senha_com_menos_de_oito_caracteres
    Cenario: Tentar cadastrar usuario com senha com menos de oito caracteres
      Dado que eu preencha o campo login com o valor "valorlogin1"
      E preencha o campo senha com o valor "valor88"
      E preencher o campo confirmar senha com o valor "valor88"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 400

    @meu_cabelereiro
    @cadastrar_usuario
    @cadastrar_usuario_todos_parametros_em_branco
    Cenario: Tentar cadastrar novo usuario passando todos os parametros em branco
      Dado que eu preencha o campo login com o valor ""
      E preencha o campo senha com o valor ""
      E preencher o campo confirmar senha com o valor ""
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 400