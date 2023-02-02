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

import gft.desafioapi.entities.Veiculo;
import gft.desafioapi.repositories.VeiculoRepository;
import gft.desafioapi.services.VeiculoService;

public class VeiculoServiceTest extends AplicationConfigTest{

	private Long veiculoId = 1l;

	@Autowired
	private VeiculoService service;

	@MockBean
	private VeiculoRepository repository;

	@MockBean
	private Veiculo veiculo;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("testando excluir veiculo ☺")
	public void testando_excluir_Veiculo() throws Exception {

		Optional<Veiculo> in = Optional.of(veiculo);

		Mockito.when(repository.findById(ArgumentMatchers.eq(veiculoId))).thenReturn(in);
		service.excluirVeiculo(veiculoId);
		Mockito.verify(repository, Mockito.times(1)).delete(ArgumentMatchers.any(Veiculo.class));
	}
}
