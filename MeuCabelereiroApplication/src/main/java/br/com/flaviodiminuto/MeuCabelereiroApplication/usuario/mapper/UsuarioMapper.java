package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.mapper;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.record.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioEntity toEntity(Usuario usuario){
        return new UsuarioEntity(
                usuario.id(),
                usuario.login(),
                usuario.senha()
        );
    }

    public Usuario toRecord(UsuarioEntity usuario){
        return new Usuario(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getSenha()
        );
    }
}
