#language: pt
  Funcionalidade: Atualizar senha
    Endpoint para atualizacao de senha de usuario da aplicacao MeuCabelereiro

    @atualizar_usuario
    @atualizar_nova_senha_igual_antiga_senha
    Cenario: Tentar atualizar senha igual a senha antiga
      Dado que eu preencha o campo login com o valor "flaviodiminuto"
      E preencha o campo senha com o valor "valor-senha"
      E preencha o campo nova senha com o valor "valor-senha"
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 304

    @atualizar_usuario
    @atualizar_senha_atual_em_branco
    Cenario: Tentar atualizar com a senha atual em branco
      Dado que eu preencha o campo login com o valor "flaviodiminuto"
      E preencha o campo senha com o valor ""
      E preencha o campo nova senha com o valor "valor-senha"
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 400

    @atualizar_usuario
    @atualizar_nova_senha_em_branco
    Cenario: Tentar atualizar com a nova senha em branco
      Dado que eu preencha o campo login com o valor "flaviodiminuto"
      E preencha o campo senha com o valor "valor-senha"
      E preencha o campo nova senha com o valor ""
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 400

    @atualizar_usuario
    @atualizar_nova_senha_e_comfirma_senha_em_branco
    Cenario: Tentar atualizar com a senha e a  nova senha em branco
      Dado que eu preencha o campo login com o valor "flaviodiminuto"
      E preencha o campo senha com o valor ""
      E preencha o campo nova senha com o valor ""
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 400

    @atualizar_usuario
    @atualizar_nova_senha_com_menos_de_oito_caracteres
    Cenario: Tentar atualizar com a nova senha com menos de oito caracteres
      Dado que eu preencha o campo login com o valor "flaviodiminuto"
      E preencha o campo senha com o valor "valor-senha"
      E preencha o campo nova senha com o valor "valor88"
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 400

    @atualizar_usuario
    @atualizar_usuario_nao_cadastrado
    Cenario: Tentar atualizar senha de usuario nao cadastrado
      Dado que eu preencha o campo login com o valor "michel"
      E preencha o campo senha com o valor "valor-senha"
      E preencha o campo nova senha com o valor "valor-senha"
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 400

    @atualizar_usuario
    @atualizar_usuario_em_branco
    Cenario: Tentar atualizar senha de usuario em branco
      Dado que eu preencha o campo login com o valor ""
      E preencha o campo senha com o valor "valor-senha"
      E preencha o campo nova senha com o valor "valor-senha"
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 400

    @atualizar_usuario
    @atualizar_fluxo_otimo
    Cenario: Atualizar usuario (fluxo otimo)
      Dado que eu preencha o campo login com o valor "flaviodiminuto"
      E preencha o campo senha com o valor "valor-senha"
      E preencha o campo nova senha com o valor "valor-88888"
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 200