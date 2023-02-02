package gft.desafioapi.entities.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import gft.desafioapi.entities.Peca;

public class PecaTest {

	private Peca peca;

	@BeforeEach
	public void setUp() {
		peca = new Peca();
	}

	@Test
	@DisplayName("testando nome ☺")
	public void testarInjecaoDeValorNoAtributoNome() throws Exception {
		peca.setNome("retrovisor");
		assertEquals("retrovisor", peca.getNome());
	}

	@Test
	@DisplayName("testando origem ☺")
	public void testar_origem_da_peca() throws Exception {
		peca.setOrigem(null);
		assertEquals(null, peca.getOrigem());
	}

	@Test
	@DisplayName("testando estoque minimo ☺")
	public void testar_estoque_minimo() throws Exception {
		peca.setEstoqueMinimo(0);
		assertEquals(0, peca.getEstoqueMinimo());
	}
	
	@Test
	@DisplayName("testando estoque máximo ☺")
	public void testar_estoque_maximo() throws Exception {
		peca.setEstoqueMaximo(0);
		assertEquals(0, peca.getEstoqueMaximo());
	}
	
	@Test
	@DisplayName("testando estoque atual ☺")
	public void testar_estoque_atual() throws Exception {
		peca.setEstoqueAtual(0);
		assertEquals(0, peca.getEstoqueAtual());
	}
	
	@Test
	@DisplayName("testando valor ☺")
	public void testar_valor() throws Exception {
		peca.setValor(null);
		assertEquals(null, peca.getValor());
	}
	
}
