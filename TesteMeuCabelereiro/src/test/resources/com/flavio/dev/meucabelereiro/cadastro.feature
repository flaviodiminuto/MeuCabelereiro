#language: pt
  Funcionalidade: Cadastro de usuario
    Teste da API para
      Cadastrar usuario
      Atualizar usuario
      Inativar usuario

    Esquema do Cenário: Tentar cadastrar novo usuario
      Dado que eu preencha o campo login com o valor "<valor-login>"
      E preencha o campo senha com o valor "<valor-senha>"
      E preencher o campo confirmar senha com o valor "<confirma-senha>"
      E enviar a requisicao para cadastrar novo usuario
      Entao devo receber o status <status-de-resposta>
      Exemplos:
        | valor-login | valor-senha | confirma-senha | status-de-resposta |
        | flavio      | valor-senha | valor-senha    | 201                |
        | flavio      | valor-senha | valor-senha    | 401                |
        | valorlogin1 | valor-senha | valor-88888    | 400                |
        |             | valor-senha | valor-senha    | 400                |
        | valorlogin1 |             | valor-senha    | 400                |
        | valorlogin1 | valor-senha |                | 400                |
        |             |             | valor-senha    | 400                |
        |             |             |                | 400                |
        | valorlogin1 | valor-senha | valor88        | 400                |

    Esquema do Cenario: Tentar atualizra um usuário existente
      Dado que eu preencha o campo login com o valor "<valor-login>"
      E preencha o campo senha com o valor "<senha-atual>"
      E preencha o campo nova senha com o valor "<nova-senha>"
      E submeta os dados para atualizar o usuario
      Entao devo receber o status <status-de-resposta>
      Exemplos:
        | valor-login | senha-atual | nova-senha     | status-de-resposta |
        | flavio      | valor-senha | valor-senha    | 400                |
        | flavio      |             | valor-senha    | 400                |
        | flavio      | valor-senha |                | 400                |
        | flavio      |             |                | 400                |
        | flavio      | valor-senha | valor88        | 400                |
        | Michel      | valor-senha | valor-88888    | 400                |
        | flavio      | valor-senha | valor-88888    | 200                |




