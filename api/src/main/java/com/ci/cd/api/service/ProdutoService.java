package com.ci.cd.api.service;

import com.ci.cd.api.dto.request.ProdutoRequest;
import com.ci.cd.api.model.Produto;
import com.ci.cd.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

	public Produto criar(ProdutoRequest request) {
		var produto = new Produto(UUID.randomUUID(), request.nome(), request.preco());
		return produtoRepository.save(produto);
	}
}
