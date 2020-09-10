package br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.entity.EnderecoEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.record.Endereco;
import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;

import javax.ws.rs.core.Response;
import java.util.List;

public class EnderecoAtualizar {


    public RespostaGenerica<EnderecoEntity> execute (List<Endereco> enderecos, Endereco endereco){
        //todo
        return new RespostaGenerica<>(new EnderecoEntity(), Response.Status.OK);
    }
}