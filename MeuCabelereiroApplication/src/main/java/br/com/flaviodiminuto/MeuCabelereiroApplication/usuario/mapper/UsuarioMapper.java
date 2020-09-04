package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.mapper;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.record.Usuario;

public class UsuarioMapper {

    public UsuarioEntity toEntity(Usuario usuario){
        if(usuario == null) return new UsuarioEntity(null, "","");
        return new UsuarioEntity(
                usuario.id(),
                usuario.login(),
                usuario.senha()
        );
    }

    public Usuario toRecord(UsuarioEntity usuario){
        if(usuario == null) return new Usuario(null,"", "");
        return new Usuario(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getSenha()
        );
    }
}
