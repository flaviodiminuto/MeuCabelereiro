#language: pt
  Funcionalidade: Atualizar senha
    Endpoint para atualizacao de senha de usuario da aplicacao MeuCabelereiro

    @meu_cabelereiro
    @atualizar_usuario
    @atualizar_cadastrar_usuario_a_ser_atualizado
    Cenario: Cadastrar usuario para tentar atualizar
      Dado que eu preencha o campo login com o valor "flaviodiminuto123"
      E preencha o campo senha com o valor "valorsenha123"
      E preencher o campo confirmar senha com o valor "valorsenha123"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 201

    @meu_cabelereiro
    @atualizar_usuario
    @atualizar_nova_senha_igual_a_senha_antiga
    Cenario: Tentar atualizar senha atual igual a senha antiga
      Dado que eu preencha o campo login com o valor "flaviodiminuto123"
      E preencha o campo senha com o valor "valorsenha123"
      E preencha o campo nova senha com o valor "valorsenha123"
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 304

    @meu_cabelereiro
    @atualizar_usuario
    @atualizar_senha_atual_em_branco
    Cenario: Tentar atualizar com a senha atual em branco
      Dado que eu preencha o campo login com o valor "flaviodiminuto123"
      E preencha o campo senha com o valor ""
      E preencha o campo nova senha com o valor "valor-senha"
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 403

    @meu_cabelereiro
    @atualizar_usuario
    @atualizar_nova_senha_em_branco
    Cenario: Tentar atualizar com a nova senha em branco
      Dado que eu preencha o campo login com o valor "flaviodiminuto123"
      E preencha o campo senha com o valor "valorsenha123"
      E preencha o campo nova senha com o valor ""
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 400

    @meu_cabelereiro
    @atualizar_usuario
    @atualizar_nova_senha_e_nova_senha_em_branco
    Cenario: Tentar atualizar com a senha atual e a  nova senha em branco
      Dado que eu preencha o campo login com o valor "flaviodiminuto123"
      E preencha o campo senha com o valor ""
      E preencha o campo nova senha com o valor ""
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 403

    @meu_cabelereiro
    @atualizar_usuario
    @atualizar_nova_senha_com_menos_de_oito_caracteres
    Cenario: Tentar atualizar com a nova senha com menos de oito caracteres
      Dado que eu preencha o campo login com o valor "flaviodiminuto123"
      E preencha o campo senha com o valor "valorsenha123"
      E preencha o campo nova senha com o valor "valor88"
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 400

    @meu_cabelereiro
    @atualizar_usuario
    @atualizar_usuario_nao_cadastrado
    Cenario: Tentar atualizar senha de usuario nao cadastrado
      Dado que eu preencha o campo login com o valor "michel"
      E preencha o campo senha com o valor "valorsenha123"
      E preencha o campo nova senha com o valor "valor-senha-nova"
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 403

    @meu_cabelereiro
    @atualizar_usuario
    @atualizar_usuario_em_branco
    Cenario: Tentar atualizar senha de usuario em branco
      Dado que eu preencha o campo login com o valor ""
      E preencha o campo senha com o valor "valorsenha123"
      E preencha o campo nova senha com o valor "valor-senha"
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 403

    @meu_cabelereiro
    @atualizar_usuario
    @atualizar_fluxo_otimo
    Cenario: Atualizar usuario (fluxo otimo)
      Dado que eu preencha o campo login com o valor "flaviodiminuto123"
      E preencha o campo senha com o valor "valorsenha123"
      E preencha o campo nova senha com o valor "valor-88888"
      E submeta os dados para atualizar o usuario
      Entao devo receber o status 200