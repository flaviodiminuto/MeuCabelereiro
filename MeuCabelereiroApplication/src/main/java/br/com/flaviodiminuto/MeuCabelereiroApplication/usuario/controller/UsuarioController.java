package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.controller;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.SalvarUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    SalvarUsuario save;

    @PostMapping
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
}
