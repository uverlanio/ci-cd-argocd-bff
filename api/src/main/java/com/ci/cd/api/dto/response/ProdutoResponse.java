package com.ci.cd.api.dto.response;

import com.ci.cd.api.model.Produto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoResponse(
		UUID id,
		String nome,
		BigDecimal preco
) {

	public static ProdutoResponse from(Produto produto) {
		return new ProdutoResponse(produto.id(), produto.nome(), produto.preco());
	}
}
