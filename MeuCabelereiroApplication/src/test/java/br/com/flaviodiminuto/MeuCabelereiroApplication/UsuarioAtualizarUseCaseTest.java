package br.com.flaviodiminuto.MeuCabelereiroApplication;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.UsuarioAtualizarUseCase;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsuarioAtualizarUseCaseTest {

    @Test
    public void camposValidos(){
        UsuarioAtualizarUseCase usecase = new UsuarioAtualizarUseCase();
        List <String> campos = Arrays.asList("login1234", "senha1234", "novasenha");
        assertTrue(usecase.camposValidos(campos));
    }
}
