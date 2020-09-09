package br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.mapper;

import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.entity.EnderecoEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.record.Endereco;
import org.springframework.stereotype.Component;

public class EnderecoMapper {

    public EnderecoEntity toEntity(Endereco endereco){
        if(endereco == null) return new EnderecoEntity(null, "", "",0, "", "", "", "", "", "",false);
        return new EnderecoEntity(
                endereco.id(),
                endereco.cep(),
                endereco.logradouro(),
                endereco.numero(),
                endereco.complemento(),
                endereco.estado(),
                endereco.cidade(),
                endereco.bairro(),
                endereco.latitude(),
                endereco.longitude(),
                endereco.ativo()
        );
    }

    public Endereco toRecord(EnderecoEntity endereco){
        if(endereco == null) return new Endereco(null, "", "",0, "", "", "", "", "", "",false);
        return new Endereco(
                endereco.getId(),
                endereco.getCep(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getEstado(),
                endereco.getCidade(),
                endereco.getBairro(),
                endereco.getLatitude(),
                endereco.getLongitude(),
                endereco.getAtivo()
        );
    }
}
