package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.controller;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.mapper.UsuarioMapper;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.persistence.UsuarioRepository;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.record.RespostaUsuario;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.record.Usuario;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.SalvarUsuario;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.UsuarioAtualizarUseCase;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.ValidadorUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    @Autowired
    SalvarUsuario save;

    @Autowired
    UsuarioRepository repository;

    UsuarioAtualizarUseCase update = new UsuarioAtualizarUseCase();
    UsuarioMapper mapper = new UsuarioMapper();

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
                if(!ValidadorUsuario.validaSenha(usuario.getSenha()))
                    return ResponseEntity.status(400).body("Senha invalida");
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
        RespostaUsuario<String> result;
        try{
            var usuarioPersistido = repository.findByLoginAndSenha(login,senhaAtual);
            var usuarioAtual = mapper.toRecord(usuarioPersistido);
            var usuarioAtualizado = new Usuario(usuarioAtual.id(), usuarioAtual.login(),novaSenha);
            result = update.execute(usuarioAtual,usuarioAtualizado);
            if(result.status().equals(200))
                result = salvarUsuario(mapper.toEntity(usuarioAtualizado));
        }catch (Exception e){
            result = respostaDeErro();
            e.printStackTrace();
        }
        return ResponseEntity.status(result.status() ).body(result.entity());
    }

    private RespostaUsuario<String> salvarUsuario(UsuarioEntity usuario){
        try{
            repository.save(usuario);
            return new RespostaUsuario<>("Operacao realizada com sucesso", 200);
        }catch (Exception e){
            return respostaDeErro();
        }
    }

    private RespostaUsuario<String> respostaDeErro(){
        return new RespostaUsuario<>("Ocorreu uma Falha inesperada",500);
    }
}
