package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.persistence.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarUsuario {

    @Autowired
    UsuarioRepository repository;

    public boolean salvar(UsuarioEntity usuario){
        UsuarioEntity persistido = repository.findByLogin(usuario.getLogin());
        if(persistido == null) {
            repository.save(usuario);
            return true;
        }else
            return false;
    }
}
