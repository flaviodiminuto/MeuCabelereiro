#language: pt
  Funcionalidade: Cadastro de usuario
    Teste da API para
      Cadastrar usuario
      Atualizar usuario
      Inativar usuario

    Esquema do Cenário: Cadastrar novo usuário
      Dado que eu preencha o campo login com o valor "<valor-login>"
      E preencha o campo senha com o valor "<valor-senha>"
      E preencher o campo confirmar senha com o valor "<confirma-senha>"
      E enviar a requisicao para cadastrar novo usuário
      Entao devo receber o status <status-de-resposta>
      Exemplos:
        | valor-login | valor-senha | confirma-senha | status-de-resposta |
        | flavio      | valor-senha | valor-senha    | 201                |
        | flavio      | valor-senha | valor-senha    | 401                |
        | valorlogi1  | valor-senha | valor-88888    | 400                |
        |             | valor-senha | valor-senha    | 400                |
        | valorlogi1  |             | valor-senha    | 400                |
        | valorlogi1  | valor-senha |                | 400                |
        |             |             | valor-senha    | 400                |
        |             |             |                | 400                |


