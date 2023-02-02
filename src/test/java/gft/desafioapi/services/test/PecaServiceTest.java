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

import gft.desafioapi.entities.Peca;
import gft.desafioapi.repositories.PecaRepository;
import gft.desafioapi.services.PecaService;

public class PecaServiceTest extends AplicationConfigTest{

	private Long pecaId = 1l;

	@Autowired
	private PecaService service;

	@MockBean
	private PecaRepository repository;

	@MockBean
	private Peca peca;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}


	@Test
	@DisplayName("testando buscar pecas ☺")
	public void testando_buscar_pecas() throws Exception {
		service.listarTodasAsPecas();
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}

	@Test
	@DisplayName("testando excluir peca ☺")
	public void testando_excluir_Peca() throws Exception {

		Optional<Peca> in = Optional.of(peca);

		Mockito.when(repository.findById(ArgumentMatchers.eq(pecaId))).thenReturn(in);
		service.excluirPeca(pecaId);
		Mockito.verify(repository, Mockito.times(1)).delete(ArgumentMatchers.any(Peca.class));
	}
}
