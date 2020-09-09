package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

public class ValidadorUsuario {

    public static boolean validaSenha(String novaSenha){
        return  novaSenha != null
                && !novaSenha.isEmpty()
                && !novaSenha.isBlank()
                && temTamanhoMinimo(novaSenha);
    }

    public static boolean temTamanhoMinimo(String string){
        int tamanho = string.length();
        return  tamanho >= 8;
    }
}
