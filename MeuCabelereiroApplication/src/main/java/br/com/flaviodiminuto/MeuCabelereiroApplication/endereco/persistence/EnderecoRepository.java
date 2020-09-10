package br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.persistence;

import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends CrudRepository<EnderecoEntity, Long> {

    @Query("select u from EnderecoEntity u where u.estado = ?1 and u.cidade = ?2 and u.bairro = ?3 and u.logradouro = ?4")
    List<EnderecoEntity> findByEstadoCidadeBairroLogradouro(String estado, String cidade, String bairro, String logradouro);

    @Query("select u from EnderecoEntity u where u.estado = ?1 and u.cidade = ?2 and u.bairro = ?3")
    List<EnderecoEntity> findByEstadoCidadeBairro(String estado, String cidade, String bairro);

}
