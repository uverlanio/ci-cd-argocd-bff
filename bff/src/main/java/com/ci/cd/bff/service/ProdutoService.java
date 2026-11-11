package com.ci.cd.bff.service;

import com.ci.cd.bff.client.ProdutoApiClient;
import com.ci.cd.bff.dto.request.ProdutoRequest;
import com.ci.cd.bff.dto.response.ProdutoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

	private final ProdutoApiClient produtoApiClient;

	public ProdutoService(ProdutoApiClient produtoApiClient) {
		this.produtoApiClient = produtoApiClient;
	}

	public List<ProdutoResponse> listar() {
		var produtos = produtoApiClient.listar();
		return produtos == null ? List.of() : produtos;
	}

	public ProdutoResponse criar(ProdutoRequest request) {
		return produtoApiClient.criar(request);
	}
}
