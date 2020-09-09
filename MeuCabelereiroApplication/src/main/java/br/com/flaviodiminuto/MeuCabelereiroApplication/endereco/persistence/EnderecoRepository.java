package br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.persistence;

import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<EnderecoEntity, Long> {

    @Query("select u from EnderecoEntity u where u.estado = ?1 and u.cidade = ?2 and u.bairro = ?3 and u.logradouro = ?4")
    EnderecoEntity findByEstadoCidadeBairroLogradouro(String estado, String cidade, String bairro, String logradouro);

    @Query("select u from EnderecoEntity u where u.estado = ?1 and u.cidade = ?2 and u.bairro = ?3")
    EnderecoEntity findByEstadoCidadeBairro(String estado, String cidade, String bairro);

}
