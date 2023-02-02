package gft.desafioapi.entities.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import gft.desafioapi.entities.Veiculo;

public class VeiculoTest {

	private Veiculo veiculo;
	
	@BeforeEach
	public void setUp() {
		veiculo = new Veiculo();
}

	@Test
	@DisplayName("testando nome do veiculo ☺")
	public void testarNome() throws Exception {
		veiculo.setNomeVeiculo("camaro");
		assertEquals("camaro", veiculo.getNomeVeiculo());
	}

	@Test
	@DisplayName("testando origem ☺")
	public void testarOrigem() throws Exception {
		veiculo.setOrigemVeiculo("EUA");
		assertEquals("EUA", veiculo.getOrigemVeiculo());
	}

	@Test
	@DisplayName("testando estoque mínimo ☺")
	public void testarEstoqueMinimo() throws Exception {
		veiculo.setEstoqueMinimoVeiculo(50);
		assertEquals(50, veiculo.getEstoqueMinimoVeiculo());
	}
	
	@Test
	@DisplayName("testando estoque máximo ☺")
	public void testarEstoqueMaximo() throws Exception {
		veiculo.setEstoqueMaximoVeiculo(1000);
		assertEquals(1000, veiculo.getEstoqueMaximoVeiculo());
	}
	@Test
	@DisplayName("testando estoque atual ☺")
	public void testarEstoqueAtual() throws Exception {
		veiculo.setEstoqueAtualVeiculo(100);
		assertEquals(100, veiculo.getEstoqueAtualVeiculo());
	}
	
	
}
