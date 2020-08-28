package com.flavio.dev.meucabelereiro;

import com.flavio.dev.meucabelereiro.config.Funcionalidade;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class MyStepdefs {
    private String login;
    private String senha;
    private String confirmaSenha;

    private ValidatableResponse resposta;
    private final String chaveTeste = String.valueOf(System.currentTimeMillis());

    @Before
    public void setup(){
        this.login = null;
        this.senha = null;
        this.confirmaSenha = null;
        this.resposta = null;
    }

    @Dado("que eu preencha o campo login com o valor {string}")
    public void queEuPreenchaOCampoLoginComOValor(String login) {
        this.login = login.concat(chaveTeste);
    }

    @E("preencha o campo senha com o valor {string}")
    public void preenchaOCampoSenhaComOValor(String senha) {
        this.senha = senha;
    }

    @E("preencher o campo confirmar senha com o valor {string}")
    public void preencherOCampoConfirmarSenhaComOValor(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    @E("enviar a requisicao para cadastrar novo usuário")
    public void enviarARequisicaoParaCadastrarNovoUsuário() {
        this.resposta = RestAssured.given().
                    params("login", this.login, "senha", this.senha, "confirma-senha",this.confirmaSenha).
                when().
                    post(Funcionalidade.USUARIO.endereco()).
                then();
    }

    @Entao("devo receber o status {int}")
    public void devoReceberOStatusStatusDeResposta(int status) {
        this.resposta.statusCode(status);
    }
}
