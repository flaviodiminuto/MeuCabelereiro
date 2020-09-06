package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorUsuarioTest {

    @Test
    @DisplayName("Senha válida")
    public void senhaValida(){
        assertTrue(ValidadorUsuario.validaSenha("novasenha"));
    }

    @Test
    @DisplayName("Senha contém menos de oito caracteres - \uD83D\uDE31")
    public void senhaComMenosDeOitoCaracteres(){
        assertFalse(ValidadorUsuario.validaSenha("nova"));
    }

    @Test
    @DisplayName("Senha vazia - \uD83D\uDE31")
    public void novaSenhaVazia(){
        assertFalse(ValidadorUsuario.validaSenha(""));
    }

    @Test
    @DisplayName("Senha igual a null - \uD83D\uDE31")
    public void senhaNula(){
        assertFalse(ValidadorUsuario.validaSenha(null));
    }
}
