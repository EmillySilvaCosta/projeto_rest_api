package gft.desafioapi.services.test;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import gft.desafioapi.entities.Pedido;
import gft.desafioapi.repositories.PedidoRepository;
import gft.desafioapi.services.PedidoService;

public class PedidoServiceTest extends AplicationConfigTest{

	private Long pedidoId = 1l;

	@Autowired
	private PedidoService service;

	@MockBean
	private PedidoRepository repository;

	@MockBean
	private Pedido pedido;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	@DisplayName("listando todos os pedidos ☺")
	public void testando_listar_todos_pedidos() throws Exception {
		service.listarTodosOsPedidos();
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}

	@Test
	@DisplayName("testando excluir pedido ☺")
	public void testando_excluir_Pedido() throws Exception {

		Optional<Pedido> in = Optional.of(pedido);

		Mockito.when(repository.findById(ArgumentMatchers.eq(pedidoId))).thenReturn(in);
		service.excluirPedido(pedidoId);
		Mockito.verify(repository, Mockito.times(1)).delete(ArgumentMatchers.any(Pedido.class));
	}
}
