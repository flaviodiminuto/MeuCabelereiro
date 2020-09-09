package br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.controller;

import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.entity.EnderecoEntity;
import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.mapper.EnderecoMapper;
import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.persistence.EnderecoRepository;
import br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.record.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/enderecos", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnderecoController {

    @Autowired
    EnderecoRepository repository;

    EnderecoMapper mapper = new EnderecoMapper();

    @PostMapping
    public ResponseEntity<String> cadastrar(Endereco endereco){
        EnderecoEntity enderecoEntity = mapper.toEntity(endereco);
        repository.save(enderecoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Endereco cadastrado com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listar(){
        Iterable<EnderecoEntity> enderecos = repository.findAll();
        List<Endereco> enderecosRecord = new ArrayList<>();
        enderecos.forEach(endereco -> enderecosRecord.add(mapper.toRecord(endereco)));
        return ResponseEntity.status(HttpStatus.OK).body(enderecosRecord);
    }

    @GetMapping("/teste")
    public ResponseEntity<Endereco> teste(){
        Endereco endereco = mapper.toRecord(null);
        return ResponseEntity.status(HttpStatus.OK).body(endereco);
    }
}
