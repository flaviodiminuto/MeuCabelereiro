package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.record.RespostaUsuario;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.record.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste do Use Case de atualização de usuário")
public class UsuarioAtualizarUseCaseTest {

    private final UsuarioAtualizarUseCase usecase;

    public UsuarioAtualizarUseCaseTest() {
        usecase = new UsuarioAtualizarUseCase();
    }

    @Test
    @DisplayName("Senha nova igual a senha antiga - \uD83D\uDE31")
    public void senhaNovaIgualSenhaAntiga(){
        var usuarioAtual = new Usuario(1L,"login1234",  "senhaAntiga");
        var usuarioAtualizado = new Usuario(1L,"login1234",  "senhaAntiga" );
        RespostaUsuario<String> resposta = usecase.execute(usuarioAtual,usuarioAtualizado);

        assertEquals(304, resposta.status());
    }

    @Test
    @DisplayName("Atualização realizada com sucesso - 200")
    public void atualizacaoFluxoOtimo(){
        //Preparacao do teste
        var usuarioAtual = new Usuario(1L,"login1234",  "senhavalida");
        var usuarioAtualizado = new Usuario(1L,"login1234",  "novasenha");

        //Execucao da operacao
        RespostaUsuario<String> resposta = usecase.execute(usuarioAtual,usuarioAtualizado);

        //Verificacao do resultado
        assertEquals(200, resposta.status());
    }
}