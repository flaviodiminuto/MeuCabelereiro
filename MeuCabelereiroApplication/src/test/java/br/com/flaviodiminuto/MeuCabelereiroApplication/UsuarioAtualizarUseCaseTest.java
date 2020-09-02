package br.com.flaviodiminuto.MeuCabelereiroApplication;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.UsuarioAtualizarUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste do Use Case de atualização de usuário")
public class UsuarioAtualizarUseCaseTest {
    UsuarioAtualizarUseCase usecase = new UsuarioAtualizarUseCase();

    @Test
    @DisplayName("Todos os campos são válidos")
    public void camposValidos(){
        List <String> campos = Arrays.asList("login1234", "senha1234", "novasenha");
        assertTrue(usecase.camposValidos(campos));
    }

    @Test
    @DisplayName("Algum campo contém menos de oito caracteres - \uD83D\uDE31")
    public void senhaComMenosDeOitoCaracteres(){
        List<String> campos = Arrays.asList("novasenha", "senhavalida","invalid" );
        assertFalse(usecase.camposValidos(campos));
    }
}
