package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.controller;

import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.entity.UsuarioEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.mapper.UsuarioMapper;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.persistence.UsuarioRepository;
import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.record.Usuario;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.UsuarioCadastrar;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase.UsuarioAtualizarUseCase;
import org.springframework.beans.factory.annotation.Autowired;
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
    UsuarioRepository repository;

    UsuarioAtualizarUseCase update = new UsuarioAtualizarUseCase();
    UsuarioCadastrar save = new UsuarioCadastrar();
    UsuarioMapper mapper = new UsuarioMapper();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> cadastrar(@RequestParam(name = "login") String login,
                                              @RequestParam(name = "senha") String senha,
                                              @RequestParam(name = "confirma-senha") String confirmaSenha ){
        RespostaGenerica<String> respostaGenerica = respostaDeErro();

        try{
            var usuario = repository.findByLoginAndSenha(login, senha);
            var id = usuario != null ? usuario.getId() : null;
            respostaGenerica = save.execute(id, senha,confirmaSenha);

            if(respostaGenerica.status().equals(200)){
                var newUsuario = new UsuarioEntity(null, login, senha);
                repository.save(newUsuario);
                respostaGenerica = new RespostaGenerica<>("Usuário cadastrado com sucesso", 201);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(respostaGenerica.status()).body(respostaGenerica.entity());
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<String> atualizar(@RequestParam String login,
                                            @RequestParam(name = "senha-atual") String senhaAtual,
                                            @RequestParam(name = "nova-senha") String novaSenha ){
        RespostaGenerica<String> result;
        try{
            var usuarioPersistido = repository.findByLoginAndSenha(login,senhaAtual);
            var usuarioAtual = mapper.toRecord(usuarioPersistido);
            var usuarioAtualizado = new Usuario(usuarioAtual.id(), usuarioAtual.login(),novaSenha);
            result = update.execute(usuarioAtual,usuarioAtualizado);
            if(result.status().equals(200)) {
                repository.save(mapper.toEntity(usuarioAtualizado));
                result = new RespostaGenerica<>("Atualização realizada com sucesso", 200);
            }
        }catch (Exception e){
            result = respostaDeErro();
            e.printStackTrace();
        }
        return ResponseEntity.status(result.status() ).body(result.entity());
    }

    private RespostaGenerica<String> respostaDeErro(){
        return new RespostaGenerica<>("Ocorreu uma Falha inesperada",500);
    }
}
