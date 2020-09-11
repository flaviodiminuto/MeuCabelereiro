package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidadorUsuarioTest {

    @Test
    @DisplayName("Senha válida")
    public void senhaValida(){
        Assertions.assertTrue(ValidadorUsuario.validaAtributo("nova1234"));
    }

    @Test
    @DisplayName("Senha contém menos de oito caracteres - \uD83D\uDE31")
    public void senhaComMenosDeOitoCaracteres(){
        assertFalse(ValidadorUsuario.validaAtributo("nova123"));
    }

    @Test
    @DisplayName("Senha vazia - \uD83D\uDE31")
    public void novaSenhaVazia(){
        assertFalse(ValidadorUsuario.validaAtributo(""));
    }

    @Test
    @DisplayName("Senha igual a null - \uD83D\uDE31")
    public void senhaNula(){
        assertFalse(ValidadorUsuario.validaAtributo(null));
    }

    @Test
    @DisplayName("Aumentando cobertura de linahs - construcao da classe")
    public void aumentoDeCobertura(){
        ValidadorUsuario validadorUsuario = new ValidadorUsuario();
        assertFalse(ValidadorUsuario.validaAtributo(null));
    }
}
