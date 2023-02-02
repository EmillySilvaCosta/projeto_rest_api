package gft.desafioapi.entities.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import gft.desafioapi.entities.Insumo;

public class InsumoTest {
	
	private Insumo insumo;

	@BeforeEach
	public void setUp() {
		insumo = new Insumo();
	}

	@Test
	@DisplayName("testando nome insumo ☺")
	public void testar_nome() throws Exception {
		insumo.setNome_insumo("vidro");
		assertEquals("vidro", insumo.getNome_insumo());
	}

	@Test
	@DisplayName("testando valor insumo ☺")
	public void testar_valor_insumo() throws Exception {
		insumo.setValor_insumo(149d);
		assertEquals(149d, insumo.getValor_insumo());
	}

	@Test
	@DisplayName("testando lista vazia")
	public void testar_lista_fornecedor() throws Exception {
		insumo.setFornecedores(null);
		assertEquals(null, insumo.getFornecedores());
	}

}
