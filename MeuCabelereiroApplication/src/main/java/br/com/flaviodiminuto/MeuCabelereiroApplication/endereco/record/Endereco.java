package br.com.flaviodiminuto.MeuCabelereiroApplication.endereco.record;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Endereco(
         @JsonProperty  String id,
         @JsonProperty  String cep,
         @JsonProperty  String logradouro,
         @JsonProperty  Integer numero,
         @JsonProperty  String complemento,
         @JsonProperty  String estado,
         @JsonProperty  String cidade,
         @JsonProperty  String bairro,
         @JsonProperty  String latitude,
         @JsonProperty  String longitude,
         @JsonProperty  Boolean ativo) {
}
