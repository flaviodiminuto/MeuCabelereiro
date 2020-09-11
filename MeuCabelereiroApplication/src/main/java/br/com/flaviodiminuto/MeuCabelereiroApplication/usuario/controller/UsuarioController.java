package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.controller;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.dto.Usuario;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.UsuarioAtualizar;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.UsuarioCadastrar;
import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    UsuarioAtualizar atualizar;
    @Autowired
    UsuarioCadastrar cadastrar;

    ModelMapper mapper = new ModelMapper();

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Usuario> cadastrar(@RequestBody @NonNull Usuario usuario){
        RespostaGenerica<UsuarioEntity> result = cadastrar.execute(usuario);
        logger.info(getMessage(result, "POST"));
        Usuario usuarioRetorno = mapper.map(result.entity(),Usuario.class);
        return ResponseEntity.status(result.status().getStatusCode()).body(usuarioRetorno);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario ){
        RespostaGenerica<UsuarioEntity> result = atualizar.execute(usuario);
        logger.info(getMessage(result, "PUT"));
        Usuario usuarioRetorno = mapper.map(result.entity(),Usuario.class);
        return ResponseEntity.status(result.status().getStatusCode()).body(usuarioRetorno);
    }

    private String getMessage(RespostaGenerica<UsuarioEntity> resposta, String metodo){
        return String.format("Operacao %s realizada com usuario %s resultou no status code %d", metodo, resposta.entity().getLogin(), resposta.status().getStatusCode());
    }
}
