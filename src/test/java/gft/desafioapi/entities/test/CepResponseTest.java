package gft.desafioapi.entities.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import gft.desafioapi.entities.CepResponse;

public class CepResponseTest {

private CepResponse cepResponse;
	
	@BeforeEach
	public void setUp() {
		cepResponse = new CepResponse();
}

	@Test
	@DisplayName("testando cep ☺")
	public void testarCep() throws Exception {
		cepResponse.setCep("81720-030");
		assertEquals("81720-030", cepResponse.getCep());
	}

	@Test
	@DisplayName("testando logradouro ☺")
	public void testarLogradouro() throws Exception {
		cepResponse.setLogradouro("rua da china");
		assertEquals("rua da china", cepResponse.getLogradouro());
	}

	@Test
	@DisplayName("testando complemento endereço ☺")
	public void testarComplemento() throws Exception {
		cepResponse.setComplemento("casa 751");
		assertEquals("casa 751", cepResponse.getComplemento());
	}
	
	@Test
	@DisplayName("testando bairro ☺")
	public void testarBairro() throws Exception {
		cepResponse.setBairro("Xaxim");
		assertEquals("Xaxim", cepResponse.getBairro());
	}
	@Test
	@DisplayName("testando localidade ☺")
	public void testarLocalidade() throws Exception {
		cepResponse.setLocalidade("Curitiba");
		assertEquals("Curitiba", cepResponse.getLocalidade());
	}
	
	@Test
	@DisplayName("testando UF - Estado ☺")
	public void testarUF() throws Exception {
		cepResponse.setUf("PR");
		assertEquals("PR", cepResponse.getUf());
	}
	
	
	
}
