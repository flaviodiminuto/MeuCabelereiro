package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.controller;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.dto.Usuario;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.UsuarioAtualizar;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.UsuarioCadastrar;
import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response.Status;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    UsuarioAtualizar atualizar;
    @Autowired
    UsuarioCadastrar cadastrar;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UsuarioEntity> cadastrar(@RequestBody Usuario usuario){
        RespostaGenerica<UsuarioEntity> result = cadastrar.execute(usuario);
        logger.info(getMessage(result));
        return ResponseEntity.status(result.status().getStatusCode()).body(result.entity());
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<UsuarioEntity> atualizar(@RequestBody Usuario usuario ){
        RespostaGenerica<UsuarioEntity> result = atualizar.execute(usuario);
        logger.info(getMessage(result));
        return ResponseEntity.status(result.status().getStatusCode()).body(result.entity());
    }

    private String getMessage(RespostaGenerica<UsuarioEntity> resposta){
        return String.format("Operacao realizada com usuario %s resultou no status code %d", resposta.entity().getLogin(), resposta.status().getStatusCode());
    }
}
