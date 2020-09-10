# Cenários de testes
## Tentar cadastrar novo usuário
### Status 201 - Created
	Login valido e senha valida
### Status 403 - Forbidden
	Login já cadastrado
### Status 400 - Bad Request
	Senha e confirmação diferentes
	Login em branco 
	Senha atual em branco
	Nova senha em branco
	Senha atual e nova senha em branco
    Senha com menos de 8 Caracteres
    
##  Tentar atualizar usuário
### Status 200 - OK
 	Login válido, correspondente a senha atual informada,
 	Senha nova diferente da atual e
 	Senha nova com no mínimo 8 caracteres
### status 304 - Not Modified
    Senha atual igual a senha antiga
### Status 400 - Bad Request
 	Nova senha em branco
 	Nova senha com menos de 8 Caracteres
### status 403 - Forbidden
 	Login em branco
    Senha atual em branco
    Login inexistente
    Senha atual incorreta
