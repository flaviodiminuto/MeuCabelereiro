package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.record.RespostaUsuario;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.record.Usuario;

public class UsuarioAtualizarUseCase {

    public RespostaUsuario<String> execute (Usuario usuarioAtual, Usuario usuarioAtualizado){

        if(usuarioAtual.id() != null && !validaSenha(usuarioAtualizado.senha()))  return new RespostaUsuario<>("Parametro invalido", 400);

        if(usuarioAtual.id() != null && usuarioAtual.senha().equals(usuarioAtualizado.senha())) return new RespostaUsuario<>("Alteração não realizada",304);

        if(usuarioAtual.id() == null)  return new RespostaUsuario<>("Não autorizado",401);

        return new RespostaUsuario<>("OK - Bora atualizar", 200);
    }

    public boolean validaSenha(String novaSenha){
        return  novaSenha != null
                && !novaSenha.isEmpty()
                && !novaSenha.isBlank()
                && temTamanhoMinimo(novaSenha);
    }

    public boolean temTamanhoMinimo(String string){
        int tamanho = string.length();
        return  tamanho >= 8;
    }
}