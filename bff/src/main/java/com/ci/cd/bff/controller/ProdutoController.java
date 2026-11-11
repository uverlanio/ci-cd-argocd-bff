package com.ci.cd.bff.controller;

import com.ci.cd.bff.dto.request.ProdutoRequest;
import com.ci.cd.bff.dto.response.ProdutoResponse;
import com.ci.cd.bff.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bff/produtos")
public class ProdutoController {

	private final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
	public ResponseEntity<List<ProdutoResponse>> listar() {
		var produtos = produtoService.listar();
		return produtos.isEmpty()
				? ResponseEntity.noContent().build()
				: ResponseEntity.ok(produtos);
	}

	@PostMapping
	public ResponseEntity<ProdutoResponse> criar(@Valid @RequestBody ProdutoRequest request) {
		return ResponseEntity.ok(produtoService.criar(request));
	}
}
