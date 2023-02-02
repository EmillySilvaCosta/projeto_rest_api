package gft.desafioapi.entities.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import gft.desafioapi.entities.Fornecedor;

public class FornecedorTest {

	private Fornecedor fornecedor;

	@BeforeEach
	public void setUp() {
		fornecedor = new Fornecedor();
	}

	@Test
	@DisplayName("testando nome ☺")
	public void testar_nome() throws Exception {
		fornecedor.setNome("Honda");
		assertEquals("Honda", fornecedor.getNome());
	}

	@Test
	@DisplayName("testando cnpj ☺")
	public void testar_cnpj() throws Exception {
		fornecedor.setCnpj(" 0561230001");;
		assertEquals(" 0561230001", fornecedor.getCnpj());
	}
	
	
}
