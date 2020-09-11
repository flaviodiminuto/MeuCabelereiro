package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.dto.Usuario;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.persistence.UsuarioRepository;
import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response.Status;

@Component
public class UsuarioCadastrar {

    @Autowired
    UsuarioRepository repository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public RespostaGenerica<UsuarioEntity> execute(Usuario usuario){
        UsuarioEntity usuarioPersistido ;
        var novoUsuario = new UsuarioEntity(null, usuario.login, usuario.senha);
        try {
            usuarioPersistido = repository.findByLoginAndSenha(usuario.login,usuario.senha);
            if (usuarioPersistido != null) return new RespostaGenerica<>(novoUsuario, Status.FORBIDDEN);

            if (!ValidadorUsuario.validaAtributo(usuario.senha) || !ValidadorUsuario.validaAtributo(usuario.login))
                return new RespostaGenerica<>(novoUsuario, Status.BAD_REQUEST);

            repository.save(novoUsuario);
            return new RespostaGenerica<>(novoUsuario, Status.CREATED);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return new RespostaGenerica<>(novoUsuario,Status.INTERNAL_SERVER_ERROR);
    }
}
