package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.usuario;

import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.persistence.EnderecoRepository;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.persistence.UsuarioRepository;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.RepositoriosMockados;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.UsuarioAtualizar;
import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.ws.rs.core.Response.Status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("Teste do Use Case de atualização de usuário")
public class UsuarioAtualizarTest extends RepositoriosMockados {

    @Autowired
    UsuarioAtualizar usecase;

    @Test
    @DisplayName("Senha nova igual a senha antiga - \uD83D\uDE31")
    public void senhaNovaIgualSenhaAntiga(){
        //Preparacao do teste
        var usuarioAtual = new UsuarioEntity(1L,"login1234",  "senhaAntiga");
        var usuarioAtualizado = new UsuarioEntity(1L,"login1234",  "senhaAntiga" );
        given(repository.findByLoginAndSenha("login1234",  "senhaAntiga")).willReturn(usuarioAtual);

        //Execucao da operacao
        RespostaGenerica<UsuarioEntity> respostaGenerica = usecase.execute(usuarioAtual,usuarioAtualizado);

        //Verificacao do resultado
        assertEquals(Status.NOT_MODIFIED, respostaGenerica.status());
    }

    @Test
    @DisplayName("Atualização realizada com sucesso - 200")
    public void atualizacaoFluxoOtimo(){
        //Preparacao do teste
        var usuarioAtual = new UsuarioEntity(1L,"login1234",  "senhavalida");
        var usuarioAtualizado = new UsuarioEntity(1L,"login1234",  "novasenha");
        given(repository.findByLoginAndSenha("login1234",  "senhavalida")).willReturn(usuarioAtual);

        //Execucao da operacao
        RespostaGenerica<UsuarioEntity> respostaGenerica = usecase.execute(usuarioAtual,usuarioAtualizado);

        //Verificacao do resultado
        assertEquals(Status.OK, respostaGenerica.status());
    }
}