package com.ci.cd.api.model;

import java.math.BigDecimal;
import java.util.UUID;

public record Produto(UUID id, String nome, BigDecimal preco) {
}
