package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.usuario;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.dto.Usuario;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.RepositoriosMockados;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.UsuarioCadastrar;
import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("Testes do use case ATUALIZAR USUARIO")
public class CadastrarUsuarioTest extends RepositoriosMockados {

    @Autowired
    UsuarioCadastrar usecase;

    @Test
    @DisplayName("Cadastrar novo usuario fluxo otimo - 200")
    public void cadastrarUsuarioSucesso() throws Exception {
        Usuario usuario = new Usuario();
        usuario.login = "loginvalido";
        usuario.senha = "senhavalida";
        given(usuarioRepository.findByLoginAndSenha(usuario.login,usuario.senha)).willReturn(null);

        RespostaGenerica<UsuarioEntity> result = usecase.execute(usuario);

        assertEquals(Status.CREATED,result.status());
    }

    @Test
    @DisplayName("Tentar cadastrar novamente usuario existente - \uD83D\uDE31")
    public void cadastrarUsuarioExistente() throws Exception {
        String login = "loginvalido";
        String senha = "senhavalida";
        Usuario usuario = new Usuario();
        usuario.login = login;
        usuario.senha = senha;
        UsuarioEntity usuarioPersistido = new UsuarioEntity(null,login,senha);
        given(usuarioRepository.findByLoginAndSenha(login,senha)).willReturn(usuarioPersistido);

        RespostaGenerica<UsuarioEntity> result = usecase.execute(usuario);

        assertEquals(Status.FORBIDDEN,result.status());
    }

    @Test
    @DisplayName("Tentar cadastrar usuario com senha em branco - \uD83D\uDE31")
    public void senhaEmBranco() throws Exception {
        String login = "loginvalido";
        String senha = "";
        Usuario usuario = new Usuario();
        usuario.login = login;
        usuario.senha = senha;
        UsuarioEntity usuarioPersistido = new UsuarioEntity(null,login,senha);
        given(usuarioRepository.findByLoginAndSenha(login,senha)).willReturn(null);

        RespostaGenerica<UsuarioEntity> result = usecase.execute(usuario);

        assertEquals(Status.BAD_REQUEST,result.status());
    }

    @Test
    @DisplayName("Tentar cadastrar usuario e receber exception- \uD83D\uDE31")
    public void excecaoAoCadastrar() throws Exception {
        Usuario usuario = new Usuario();
        given(usuarioRepository.findByLoginAndSenha(null,null)).willThrow(new Exception("Teste de excecao no fluxo de cadastro de usuario"));

        RespostaGenerica<UsuarioEntity> result = usecase.execute(usuario);

        assertEquals(Status.INTERNAL_SERVER_ERROR,result.status());
    }
}
