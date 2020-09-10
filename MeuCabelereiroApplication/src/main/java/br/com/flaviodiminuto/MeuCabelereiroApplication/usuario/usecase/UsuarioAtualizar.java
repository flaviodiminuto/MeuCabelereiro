package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.persistence.UsuarioRepository;
import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response.Status;

@Service
public class UsuarioAtualizar {

    @Autowired
    UsuarioRepository repository;


    public RespostaGenerica<UsuarioEntity> execute (UsuarioEntity usuarioAtual, UsuarioEntity usuarioAtualizado){
        var usuarioPersistido = repository.findByLoginAndSenha(usuarioAtual.getLogin(),usuarioAtual.getSenha());

        if(usuarioPersistido == null)  return new RespostaGenerica<>(usuarioAtualizado, Status.FORBIDDEN);

        boolean senhaValida = ValidadorUsuario.validaSenha(usuarioAtualizado.getSenha());
        if(usuarioPersistido.getId() != null && !senhaValida)  return new RespostaGenerica<>(usuarioAtualizado, Status.BAD_REQUEST);

        if(usuarioPersistido.getId() != null && usuarioPersistido.getSenha().equals(usuarioAtualizado.getSenha())) return new RespostaGenerica<>(usuarioAtualizado, Status.NOT_MODIFIED);

        var aux = new UsuarioEntity(usuarioPersistido.getId(),usuarioAtualizado.getLogin(),usuarioAtualizado.getSenha());
        repository.save(aux);
        return new RespostaGenerica<>(aux, Status.OK);
    }
}