# Cenários de testes
## Tentar cadastrar novo usuário
### Status 201 - Created
	Login valido e senha valida
### Status 403 - Forbidden
	Login já cadastrado
### Status 400 - Bad Request
	Login em branco ou com menos de 8 caracteres
	Senha atual em branco
	Senha em branco
    Senha com menos de 8 Caracteres
    
##  Tentar atualizar usuário
### Status 200 - OK
 	Login válido existente e senha  diferente da atual e com no mínimo 8 caracteres
### status 304 - Not Modified
    Senha atual igual a senha antiga
### Status 400 - Bad Request
 	Senha em branco
 	Ssenha com menos de 8 Caracteres
### status 403 - Forbidden
 	Usuario Inexistente
