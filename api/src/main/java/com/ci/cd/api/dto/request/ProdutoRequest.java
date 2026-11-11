package com.ci.cd.api.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoRequest(
		@NotBlank String nome,
		@NotNull @DecimalMin("0.01") BigDecimal preco) {
}
