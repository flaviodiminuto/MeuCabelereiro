package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.controller;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.SalvarUsuario;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.UsuarioAtualizarUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    @Autowired
    SalvarUsuario save;
    @Autowired
    UsuarioAtualizarUseCase update;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> cadastrar(@RequestParam(name = "login") String login,
                                              @RequestParam(name = "senha") String senha,
                                              @RequestParam(name = "confirma-senha") String confirmaSenha ){
        var status = HttpStatus.BAD_REQUEST;
        var mensagem = "campo invalido";
        try{
            if(login != null && !login.isEmpty()
            && senha != null && !senha.isEmpty()
            && senha.equals(confirmaSenha)) {
                var usuario = new UsuarioEntity(null, login,senha);
                if(save.salvar(usuario)) {
                    status = HttpStatus.CREATED;
                    mensagem = "usuario cadastrado com sucesso";
                }else{
                    status = HttpStatus.UNAUTHORIZED;
                    mensagem = "Login já utilizado";
                }
            }
        }catch (Exception e){
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            mensagem = "Ocorreu uma falha inesperada";
        }
        return ResponseEntity.status(status).body(mensagem);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<String> atualizar(@RequestParam String login,
                                            @RequestParam(name = "senha-atual") String senhaAtual,
                                            @RequestParam(name = "nova-senha") String novaSenha ){
        var result = update.execute(login,senhaAtual,novaSenha);
        return ResponseEntity.status(result.status() ).body(result.mensagem());

    }
}
