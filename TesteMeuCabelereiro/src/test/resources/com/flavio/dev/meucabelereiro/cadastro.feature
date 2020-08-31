#language: pt
  Funcionalidade: Cadastro de usuario
    Teste da API para
      Cadastrar usuario
      Atualizar usuario
      Inativar usuario

    Esquema do Cenario: Tentar cadastrar novo usuario
      Dado que eu preencha o campo login com o valor "<valor-login>"
      E preencha o campo senha com o valor "<valor-senha>"
      E preencher o campo confirmar senha com o valor "<confirma-senha>"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status <status-de-resposta>
      Exemplos:
        | valor-login    | valor-senha | confirma-senha | status-de-resposta |
        | valorlogin1    | valor-senha | valor-88888    | 400                |
        |                | valor-senha | valor-senha    | 400                |
        | valorlogin1    |             | valor-senha    | 400                |
        | valorlogin1    | valor-senha |                | 400                |
        |                |             | valor-senha    | 400                |
        | valorlogin1    | valor-senha | valor88        | 400                |

    @cadastrar_fluxo_otimo
    Cenario: Tentar cadastrar novo usuario passando todos os parametros em branco
      Dado que eu preencha o campo login com o valor "flaviodiminuto"
      E preencha o campo senha com o valor "valor-senha"
      E preencher o campo confirmar senha com o valor "valor-senha"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 201


    @cadastrar_usuario_existente
    Cenario: Tentar cadastrar novo usuario passando todos os parametros em branco
      Dado que eu preencha o campo login com o valor "flaviodiminuto"
      E preencha o campo senha com o valor "valor-senha"
      E preencher o campo confirmar senha com o valor "valor-senha"
      E enviar a requisicao para cadastrar novo usuario
      #Preencher novamente os mesmos dados
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 401

    @cadastrar_todos_parametros_em_branco
    Cenario: Tentar cadastrar novo usuario passando todos os parametros em branco
      Dado que eu preencha o campo login com o valor ""
      E preencha o campo senha com o valor ""
      E preencher o campo confirmar senha com o valor ""
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status 400

    Esquema do Cenario: Tentar atualizra um usuário existente
      Dado que eu preencha o campo login com o valor "<valor-login>"
      E preencha o campo senha com o valor "<senha-atual>"
      E preencha o campo nova senha com o valor "<nova-senha>"
      E submeta os dados para atualizar o usuario
      Entao devo receber o status <status-de-resposta>
      Exemplos:
        | valor-login    | senha-atual | nova-senha     | status-de-resposta |
        | flaviodiminuto | valor-senha | valor-senha    | 400                |
        | flaviodiminuto |             | valor-senha    | 400                |
        | flaviodiminuto | valor-senha |                | 400                |
        | flaviodiminuto |             |                | 400                |
        | flaviodiminuto | valor-senha | valor88        | 400                |
        | Michel         | valor-senha | valor-senha    | 400                |
        | flaviodiminuto | valor-senha | valor-88888    | 200                |


