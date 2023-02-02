package gft.desafioapi.entities.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import gft.desafioapi.entities.Cliente;


public class ClienteTest {
	
	private Cliente cliente;

	@BeforeEach
	public void setUp() {
		cliente = new Cliente();
	}

	@Test
	@DisplayName("testando nome ☺")
	public void testarNome() throws Exception {
		cliente.setNome("José");
		assertEquals("José", cliente.getNome());
	}

	@Test
	@DisplayName("testando e-mail ☺")
	public void testarEmail() throws Exception {
		cliente.setEmail("emilly@gft.com");;
		assertEquals("emilly@gft.com", cliente.getEmail());
	}

	@Test
	@DisplayName("testando cpf ☺")
	public void testarCpf() throws Exception {
		cliente.setCpf("044583045-09");
		assertEquals("044583045-09", cliente.getCpf());
	}
	
	@Test
	@DisplayName("testando endereço ☺")
	public void testarEndereço() throws Exception {
		cliente.setEndereco(null);;
		assertEquals(null, cliente.getEndereco());
	}
}
