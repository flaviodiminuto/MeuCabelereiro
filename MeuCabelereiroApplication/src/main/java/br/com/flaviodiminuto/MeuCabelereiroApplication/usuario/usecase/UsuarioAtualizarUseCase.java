package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.record.Usuario;

public class UsuarioAtualizarUseCase {


    public RespostaGenerica<String> execute (Usuario usuarioAtual, Usuario usuarioAtualizado){

        boolean senhaValida = ValidadorUsuario.validaSenha(usuarioAtualizado.senha());
        if(usuarioAtual.id() != null && !senhaValida)  return new RespostaGenerica<>("Parametro invalido", 400);

        if(usuarioAtual.id() != null && usuarioAtual.senha().equals(usuarioAtualizado.senha())) return new RespostaGenerica<>("Alteração não realizada",304);

        if(usuarioAtual.id() == null)  return new RespostaGenerica<>("Não autorizado",401);

        return new RespostaGenerica<>("OK - Bora atualizar", 200);
    }
}