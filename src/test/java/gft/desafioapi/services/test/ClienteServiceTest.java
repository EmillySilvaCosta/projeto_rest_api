package gft.desafioapi.services.test;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import gft.desafioapi.entities.Cliente;
import gft.desafioapi.repositories.ClienteRepository;
import gft.desafioapi.services.ClienteService;


public class ClienteServiceTest extends AplicationConfigTest{

	@MockBean
	private ClienteRepository clienteRepository;

	@MockBean
	private Cliente cliente;

	@Autowired
	private ClienteService clienteService;

	@BeforeEach
	public void setUp() {
		cliente = new Cliente();

	}

	@Test
	@DisplayName("salvando cliente ☺") //erro
	public void testar_se_cliente_foi_salvo() throws Exception{

		Cliente cliente = Mockito.mock(Cliente.class);
		clienteService.salvarCliente(cliente);
		Mockito.verify(clienteRepository, Mockito.times(1)).save(ArgumentMatchers.any(Cliente.class));

	}

	@Test
	@DisplayName("excluindo cliente ☺")
	public void testar_se_cliente_foi_excluido() throws Exception{

		Long clienteId = 1l;

		Cliente cliente = Mockito.mock(Cliente.class);

		Optional<Cliente> cli = Optional.of(cliente);

		Mockito.when(clienteRepository.findById(ArgumentMatchers.eq(clienteId))).thenReturn(cli);

		clienteService.excluirCliente(clienteId); 

		Mockito.verify(clienteRepository, Mockito.times(1)).deleteById(ArgumentMatchers.any(Long.class));


	}
}
