package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.persistence;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {

    @Query("select u from UsuarioEntity u where u.login = ?1")
    UsuarioEntity findByLogin(String login);

    @Query("select u from UsuarioEntity u where u.login = ?1 and u.senha = ?2")
    UsuarioEntity findByLoginAndSenha(String login, String senha);

}
