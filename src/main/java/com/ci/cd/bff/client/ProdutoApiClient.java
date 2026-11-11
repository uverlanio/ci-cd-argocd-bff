package com.ci.cd.bff.client;

import com.ci.cd.bff.dto.request.ProdutoRequest;
import com.ci.cd.bff.dto.response.ProdutoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "produto-api", url = "${api.produtos.url}")
public interface ProdutoApiClient {

	@GetMapping("/api/produtos")
	List<ProdutoResponse> listar();

	@PostMapping("/api/produtos")
	ProdutoResponse criar(@RequestBody ProdutoRequest request);
}
