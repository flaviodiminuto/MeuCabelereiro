package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.record.RespostaUsuario;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.record.Usuario;

public class UsuarioAtualizarUseCase {


    public RespostaUsuario<String> execute (Usuario usuarioAtual, Usuario usuarioAtualizado){

        boolean senhaValida = ValidadorUsuario.validaSenha(usuarioAtualizado.senha());
        if(usuarioAtual.id() != null && !senhaValida)  return new RespostaUsuario<>("Parametro invalido", 400);

        if(usuarioAtual.id() != null && usuarioAtual.senha().equals(usuarioAtualizado.senha())) return new RespostaUsuario<>("Alteração não realizada",304);

        if(usuarioAtual.id() == null)  return new RespostaUsuario<>("Não autorizado",401);

        return new RespostaUsuario<>("OK - Bora atualizar", 200);
    }
}