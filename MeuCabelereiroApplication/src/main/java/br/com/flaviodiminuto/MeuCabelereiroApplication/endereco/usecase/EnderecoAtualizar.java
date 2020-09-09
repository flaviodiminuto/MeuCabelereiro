package br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.record.Endereco;
import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;

import java.util.List;

public class EnderecoAtualizar {


    public RespostaGenerica<String> execute (List<Endereco> enderecos, Endereco endereco){
        //todo
        return new RespostaGenerica<>("OK - Bora atualizar", 200);
    }
}