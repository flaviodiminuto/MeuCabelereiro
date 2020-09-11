package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.dto.Usuario;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.persistence.UsuarioRepository;
import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response.Status;

@Service
public class UsuarioAtualizar {

    @Autowired
    UsuarioRepository repository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public RespostaGenerica<UsuarioEntity> execute (Usuario usuario){
        UsuarioEntity usuarioPersistido = new UsuarioEntity(null,usuario.login,usuario.senha);

        try {
            usuarioPersistido = repository.findByLogin(usuario.login);
            if(usuarioPersistido == null) return new RespostaGenerica<>(new UsuarioEntity(null,usuario.login,usuario.senha),Status.FORBIDDEN);

            if (usuarioPersistido.getId() == null ) return new RespostaGenerica<>(usuarioPersistido, Status.FORBIDDEN);

            boolean senhaValida = ValidadorUsuario.validaAtributo(usuario.senha);
            if (usuarioPersistido.getId() != null && !senhaValida) return new RespostaGenerica<>(usuarioPersistido, Status.BAD_REQUEST);

            if (usuarioPersistido.getId() != null && usuarioPersistido.getSenha().equals(usuario.senha))
                return new RespostaGenerica<>(usuarioPersistido, Status.NOT_MODIFIED);

            var aux = new UsuarioEntity(usuarioPersistido.getId(), usuario.login, usuario.senha);
            repository.save(aux);
            return new RespostaGenerica<>(aux, Status.OK);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return new RespostaGenerica<>(usuarioPersistido,Status.INTERNAL_SERVER_ERROR);
    }
}