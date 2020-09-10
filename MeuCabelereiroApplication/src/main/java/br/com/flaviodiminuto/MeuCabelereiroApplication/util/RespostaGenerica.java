package br.com.flaviodiminuto.MeuCabelereiroApplication.util;

import javax.ws.rs.core.Response.Status;

public record RespostaGenerica<S>(S entity, Status status) {
}
