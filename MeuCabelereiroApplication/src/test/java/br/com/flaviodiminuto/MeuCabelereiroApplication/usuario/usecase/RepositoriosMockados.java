package br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.usecase;

import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.persistence.EnderecoRepository;
import br.com.flaviodiminuto.MeuCabelereiroApplication.usuario.persistence.UsuarioRepository;
import org.springframework.boot.test.mock.mockito.MockBean;

public class RepositoriosMockados {

    @MockBean
    public UsuarioRepository repository;

    @MockBean
    public EnderecoRepository enderecoRepository;
}
