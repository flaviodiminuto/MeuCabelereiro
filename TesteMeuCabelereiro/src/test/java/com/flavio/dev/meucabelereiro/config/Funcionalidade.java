package com.flavio.dev.meucabelereiro.config;

public enum Funcionalidade {
    USUARIO("/usuarios");

    private String endereco;
    Funcionalidade(String endereco) {
        this.endereco = endereco;
    }
    public String endereco(){
        return this.endereco;
    }
}
