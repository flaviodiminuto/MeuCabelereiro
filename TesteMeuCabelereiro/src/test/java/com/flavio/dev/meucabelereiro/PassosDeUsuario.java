package com.flavio.dev.meucabelereiro;

import com.flavio.dev.meucabelereiro.Util.SendRequestUtil;
import com.flavio.dev.meucabelereiro.config.Funcionalidade;
import com.flavio.dev.meucabelereiro.model.Usuario;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class PassosDeUsuario {

    private Usuario usuario;
    private ValidatableResponse resposta;

    @Before
    public void setup(){
        usuario = new Usuario();
    }

    @Dado("que eu preencha o campo login com o valor {string}")
    public void queEuPreenchaOCampoLoginComOValor(String login) {
        usuario.login = SendRequestUtil.unique(login);
    }

    @E("preencha o campo senha com o valor {string}")
    public void preenchaOCampoSenhaComOValor(String senha) {
        usuario.senha = senha;
    }

    @E("enviar a requisicao para cadastrar novo usuario")
    public void enviarARequisicaoParaCadastrarNovoUsuario() {
        String methods = "GET,POST,PUT";
        String headers = "X-Custom";
        this.resposta = RestAssured.given().
                    header("Access-Control-Request-Method", methods).
                    header("Access-Control-Request-Headers", headers).
                    body(usuario).
                    contentType(ContentType.JSON).
                when().
                    post(Funcionalidade.USUARIO.endereco()).
                then();
    }

    @Entao("devo receber o status {int}")
    public void devoReceberOStatusStatusDeResposta(int status) {
        this.resposta.statusCode(status);
    }

    @E("preencha o campo nova senha com o valor {string}")
    public void preenchaOCampoNovaSenhaComOValor(String senha) {
        usuario.senha = senha;
    }

    @E("submeta os dados para atualizar o usuario")
    public void submetaOsDadosParaAtualizarOUsuario() {
        String methods = "GET,POST,PUT";
        String headers = "X-Custom";
        this.resposta = RestAssured.given().
                header("Access-Control-Request-Method", methods).
                header("Access-Control-Request-Headers", headers).
                body(usuario).
                contentType(ContentType.JSON).
                when().
                    put(Funcionalidade.USUARIO.endereco()).
                then();
    }
}
