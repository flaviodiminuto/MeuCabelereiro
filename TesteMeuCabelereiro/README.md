# Cenários de testes
## Tentar cadastrar novo usuário
### Status 201
	Login valido e senha valida
### Status 401
	Login já cadastrado
### Status 400
	Senha e confirmação diferentes
	Login em branco 
	Senha atual em branco
	Nova senha em branco
	Senha atual e nova senha em branco
    Senha com menos de 8 Caracteres
    
##  Tentar cadastrar novo usuário
### Status 200
 	Login válido, correspondente a senha atual informada,
 	Senha nova diferente da atual e
 	Senha nova com no mínimo 8 caracteres
### Status 400
 	Senha atual e nova senha iguais
 	Login em branco 
 	Senha em branco
 	Confirma;áo de senha em branco
 	Slogin e senha em branco
 	Login, senha e confirmação em branco
 	Senha com menos de 8 Caracteres
