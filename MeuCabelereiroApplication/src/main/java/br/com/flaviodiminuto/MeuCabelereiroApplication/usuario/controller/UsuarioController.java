package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.controller;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.UsuarioAtualizar;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.UsuarioCadastrar;
import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response.Status;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    UsuarioAtualizar atualizar;
    @Autowired
    UsuarioCadastrar cadastrar;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UsuarioEntity> cadastrar(@RequestParam(name = "login") String login,
                                              @RequestParam(name = "senha") String senha,
                                              @RequestParam(name = "confirma-senha") String confirmaSenha ){
        RespostaGenerica<UsuarioEntity> result = new RespostaGenerica<>(new UsuarioEntity(null,login,senha), Status.INTERNAL_SERVER_ERROR);
        try{
            result = cadastrar.execute(login, senha,confirmaSenha);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(result.status().getStatusCode()).body(result.entity());
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<UsuarioEntity> atualizar(@RequestParam String login,
                              @RequestParam(name = "senha-atual") String senhaAtual,
                              @RequestParam(name = "nova-senha") String novaSenha ){
        var usuarioAtual = new UsuarioEntity(null, login,senhaAtual);
        var usuarioAtualizado = new UsuarioEntity(null,login,novaSenha);
        RespostaGenerica<UsuarioEntity> result = new RespostaGenerica<>(usuarioAtualizado, Status.INTERNAL_SERVER_ERROR);
        try{
            result = atualizar.execute(usuarioAtual,usuarioAtualizado);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(result.status().getStatusCode()).body(result.entity());
    }
}
