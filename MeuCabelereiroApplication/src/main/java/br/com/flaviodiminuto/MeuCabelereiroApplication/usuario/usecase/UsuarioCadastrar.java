package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;

public class UsuarioCadastrar {

    public RespostaGenerica<String> execute(Long id, String senha, String confirmaSenha){

        if(id != null) return new RespostaGenerica<>("Usuário já cadastrado", 401);

        if(!ValidadorUsuario.validaSenha(senha)) return new RespostaGenerica<>("Senha inválida", 400);

        if(!senha.equals(confirmaSenha)) return new RespostaGenerica<>("Confirmacao de senha diferente da senha", 400);

        return new RespostaGenerica<>("", 200);
    }
}
