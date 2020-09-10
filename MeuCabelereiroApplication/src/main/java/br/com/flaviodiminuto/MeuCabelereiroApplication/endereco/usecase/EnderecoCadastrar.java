package br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.entity.EnderecoEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.record.Endereco;
import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class EnderecoCadastrar {

    public RespostaGenerica<EnderecoEntity> execute(Endereco endereco){
        //todo
        return new RespostaGenerica<>(new EnderecoEntity(), Response.Status.OK);
    }
}
