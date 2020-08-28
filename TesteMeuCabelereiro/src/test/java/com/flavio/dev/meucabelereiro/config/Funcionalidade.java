package com.flavio.dev.meucabelereiro.config;

public enum Funcionalidade {
    USUARIO("/usuarios");

    private String endereco;
    Funcionalidade(String endereco) {
        this.endereco = endereco;
    }
    public String endereco(){
        //Adicione o endereço de sua aplicacao (exemplo -> https://minha-aplicacao.com.br)
        return "{HOSTNAME}".concat(this.endereco);
    }
}
