package com.ci.cd.bff.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoResponse(UUID id, String nome, BigDecimal preco) {
}
