package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.usuario;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.dto.Usuario;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.RepositoriosMockados;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.UsuarioAtualizar;
import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.ws.rs.core.Response.Status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("Teste do Use Case de atualização de usuário")
public class UsuarioAtualizarTest extends RepositoriosMockados {

    @Autowired
    UsuarioAtualizar usecase;

    @Test
    @DisplayName("Atualização de usuario realizada com sucesso - 200")
    public void atualizacaoFluxoOtimo() throws Exception {
        //Preparacao do teste
        var usuarioEntity = new UsuarioEntity(1L,"login1234",  "senhavalida");
        var usuario = new Usuario();
        usuario.login = "loginvalido";
        usuario.senha = String.valueOf(System.currentTimeMillis());
        given(usuarioRepository.findByLogin(usuario.login)).willReturn(usuarioEntity);
        given(usuarioRepository.save(usuarioEntity)).willReturn(usuarioEntity);

        //Execucao da operacao
        RespostaGenerica<UsuarioEntity> respostaGenerica = usecase.execute(usuario);

        //Verificacao do resultado
        assertEquals(Status.OK, respostaGenerica.status());
    }

    @Test
    @DisplayName("Tentar atualizar usuario com senha antiga e nova iguais - \uD83D\uDE31")
    public void senhaSemAlteracao() throws Exception {
        var usuarioEntity = new UsuarioEntity(1L,"login1234",  "senhaantiga");
        var usuario = new Usuario();
        usuario.login =  usuarioEntity.getLogin();
        usuario.senha = usuarioEntity.getSenha();
        given(usuarioRepository.findByLogin(usuario.login)).willReturn(usuarioEntity);

        RespostaGenerica<UsuarioEntity> respostaGenerica = usecase.execute(usuario);

        //Verificacao do resultado
        assertEquals(Status.NOT_MODIFIED, respostaGenerica.status());
    }

    @Test
    @DisplayName("Exception ao tentar atualizar usuario - \uD83D\uDE31")
    public void atualizacaoComException() throws Exception {
        var usuarioEntity = new UsuarioEntity(1L,"login1234",  "senhaantiga");
        var usuario = new Usuario();
        usuario.login =  usuarioEntity.getLogin();
        usuario.senha = usuarioEntity.getSenha();
        given(usuarioRepository.findByLogin(usuario.login)).willThrow(new Exception("Teste do fluxo de execao da atualizacao de usuario"));

        RespostaGenerica<UsuarioEntity> respostaGenerica = usecase.execute(usuario);

        //Verificacao do resultado
        assertEquals(Status.INTERNAL_SERVER_ERROR, respostaGenerica.status());
    }
}