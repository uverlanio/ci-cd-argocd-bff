package com.ci.cd.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProdutoControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@BeforeEach
	void limparProdutos() {
		jdbcTemplate.update("DELETE FROM produtos");
	}

	@Test
	void deveRetornar204QuandoNaoExistiremProdutos() throws Exception {
		mockMvc.perform(get("/api/produtos"))
				.andExpect(status().isNoContent());
	}

	@Test
	void deveCriarProdutoEListarCom200() throws Exception {
		mockMvc.perform(post("/api/produtos")
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
								{"nome":"Teclado","preco":129.90}
								"""))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").isNotEmpty())
				.andExpect(jsonPath("$.nome").value("Teclado"));

		mockMvc.perform(get("/api/produtos"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].nome").value("Teclado"));
	}

	@Test
	void deveRetornar400QuandoRequestForInvalido() throws Exception {
		mockMvc.perform(post("/api/produtos")
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
								{"nome":"","preco":0}
								"""))
				.andExpect(status().isBadRequest());
	}
}
