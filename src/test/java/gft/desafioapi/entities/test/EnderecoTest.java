package gft.desafioapi.entities.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import gft.desafioapi.entities.Endereco;


public class EnderecoTest {
	
	private Endereco endereco;

	@BeforeEach
	public void setUp() {
		endereco = new Endereco();
	}

	@Test
	@DisplayName("testando logradouro ☺")
	public void testar_logradouro() throws Exception {
		endereco.setLogradouro("rua das orquideas");
		assertEquals("rua das orquideas", endereco.getLogradouro());
	}

	@Test
	@DisplayName("testando numero ☺")
	public void testar_numero() throws Exception {
		endereco.setNumero("751");
		assertEquals("751", endereco.getNumero());
	}

	@Test
	@DisplayName("testando complemento ☺")
	public void testar_complemento() throws Exception {
		endereco.setComplemento("sobrado 17");
		assertEquals("sobrado 17", endereco.getComplemento());
	}
	
	@Test
	@DisplayName("testando cep ☺")
	public void testar_cep() throws Exception {
		endereco.setCep("81720030");
		assertEquals("81720030", endereco.getCep());
	}
}
