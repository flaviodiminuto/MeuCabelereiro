package br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.record.Endereco;
import br.com.flaviodiminuto.MeuCabelereiroApplication.util.RespostaGenerica;
import org.springframework.stereotype.Component;

@Component
public class EnderecoCadastrar {

    public RespostaGenerica<String> execute(Endereco endereco){
        //todo
        return new RespostaGenerica<>("OK - bora cadastrar", 200);
    }
}
