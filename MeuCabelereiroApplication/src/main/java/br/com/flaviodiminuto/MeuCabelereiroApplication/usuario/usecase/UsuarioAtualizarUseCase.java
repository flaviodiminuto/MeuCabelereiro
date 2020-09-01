package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.mapper.UsuarioMapper;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.persistence.UsuarioRepository;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.record.RespostaUsuario;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.record.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Component
public class UsuarioAtualizarUseCase {

    @Autowired
    UsuarioRepository repository;

    public RespostaUsuario execute (String login, String senha, String novaSenha){
        List<String> campos = Arrays.asList(login,senha,novaSenha);

        if(!camposValidos(campos)) {
            return new RespostaUsuario("Parametro invalido", 400);
        }

        if(senha.equals(novaSenha))
            return new RespostaUsuario("Alteração não realizada",304);

        UsuarioEntity usuario = repository.findByLoginAndSenha(login,senha);

        if(usuario == null)
            return new RespostaUsuario("Não autorizado",401);

        //Bom, se nada mais pode estar errado então vamos atualizar o usuário
        usuario.setSenha(novaSenha);
        repository.save(usuario);
        return new RespostaUsuario("Atualizado com sucesso", 200);
    }

    public boolean camposValidos(List<String> campos){
        Stream<String> stream = campos.stream();
        int validos = (int) stream.
                filter(s -> !s.isEmpty()).
                filter(s -> !s.isBlank()).
                filter(this::tamanhoMinimo).
                count();
        return validos == campos.size();
    }

    public boolean tamanhoMinimo(String string){
        return string.length() >= 8;
    }
}