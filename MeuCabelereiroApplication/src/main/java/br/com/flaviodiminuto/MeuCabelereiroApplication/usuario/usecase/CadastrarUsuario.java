package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.record.RespostaUsuario;
import org.springframework.stereotype.Component;

@Component
public class CadastrarUsuario {

    public RespostaUsuario<String> execute(Long id, String senha, String confirmaSenha){

        if(id != null) return new RespostaUsuario<>("Usuário já cadastrado", 401);

        if(!ValidadorUsuario.validaSenha(senha)) return new RespostaUsuario<>("Senha inválida", 400);

        if(!senha.equals(confirmaSenha)) return new RespostaUsuario<>("Confirmacao de senha diferente da senha", 400);

        return new RespostaUsuario<>("", 200);
    }
}
