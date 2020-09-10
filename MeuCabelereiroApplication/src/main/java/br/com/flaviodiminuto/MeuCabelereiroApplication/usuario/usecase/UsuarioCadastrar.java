package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.persistence.UsuarioRepository;
import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response.Status;

@Component
public class UsuarioCadastrar {

    @Autowired
    UsuarioRepository repository;

    public RespostaGenerica<UsuarioEntity> execute(String login, String senha, String confirmaSenha){
        var usuarioPersistido = repository.findByLoginAndSenha(login,senha);
        var novoUsuario =  new UsuarioEntity(null,login,senha);

        if (usuarioPersistido != null) return new RespostaGenerica<>(novoUsuario, Status.FORBIDDEN);

        if(!ValidadorUsuario.validaSenha(senha) || !senha.equals(confirmaSenha)) return new RespostaGenerica<>(novoUsuario, Status.BAD_REQUEST);

        repository.save(novoUsuario);
        return new RespostaGenerica<>(novoUsuario, Status.CREATED);
    }
}
