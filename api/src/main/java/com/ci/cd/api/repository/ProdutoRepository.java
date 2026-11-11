package com.ci.cd.api.repository;

import com.ci.cd.api.model.Produto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepository {

	private final JdbcTemplate jdbcTemplate;

	public ProdutoRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Produto> findAll() {
		return jdbcTemplate.query(
				"SELECT id, nome, preco FROM produtos ORDER BY nome",
				(resultSet, rowNumber) -> new Produto(
						resultSet.getObject("id", java.util.UUID.class),
						resultSet.getString("nome"),
						resultSet.getBigDecimal("preco")));
	}

	public Produto save(Produto produto) {
		jdbcTemplate.update(
				"INSERT INTO produtos (id, nome, preco) VALUES (?, ?, ?)",
				produto.id(),
				produto.nome(),
				produto.preco());
		return produto;
	}
}
