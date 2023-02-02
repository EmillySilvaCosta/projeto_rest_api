package gft.desafioapi.entities.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import gft.desafioapi.entities.Pedido;

public class PedidoTest {

	private Pedido pedido;

	@BeforeEach
	public void setUp() {
		pedido = new Pedido();
	}

	@Test
	@DisplayName("testando lista peças ☺")
	public void testar_lista_pecas() throws Exception {
		pedido.setPecas(null);
		assertEquals(null, pedido.getPecas());
	}

	@Test
	@DisplayName("testando valor total ☺")
	public void testar_valor_total() throws Exception {
		pedido.setValorTotal();
		assertEquals(0, pedido.getValorTotal());
	}

	@Test
	@DisplayName("testando quantidade total ☺")
	public void testar_quantidade_total() throws Exception {
		pedido.setQtdTotal();
		assertEquals(0, pedido.getQtdTotalPecas());
	}
	
	@Test
	@DisplayName("testando quantidade total de peças ☺")
	public void testar_quantidade_total_de_peças() throws Exception {
		pedido.setQtdTotalPecas();
		assertEquals(0, pedido.getQtdTotalPecas());
	}
	@Test
	@DisplayName("testando quantidade total de veículos ☺")
	public void testar_quantidade_total_de_veículos() throws Exception {
		pedido.setQtdTotalVeiculos();
		assertEquals(0, pedido.getQtdTotalVeiculos());
	}
}
