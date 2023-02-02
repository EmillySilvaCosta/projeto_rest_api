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
import org.springframework.data.domain.Pageable;

import gft.desafioapi.entities.Insumo;
import gft.desafioapi.repositories.InsumoRepository;
import gft.desafioapi.services.InsumoService;

public class InsumoServiceTest extends AplicationConfigTest{
	
	private Long insumoId = 1l;

	@Autowired
	private InsumoService service;

	@MockBean
	private InsumoRepository repository;

	@MockBean
	private Insumo insumo;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("testando salvar insumo ☺")
	public void salvar_Insumo() throws Exception {

		Insumo insumo = Mockito.mock(Insumo.class);
		service.salvarInsumo(insumo);
		Mockito.verify(repository, Mockito.times(1)).save(ArgumentMatchers.any(Insumo.class));
	}

	@Test
	@DisplayName("testando buscar insumos ☺")
	public void testando_buscar_insumoes() throws Exception {
		Pageable pageable = null;
		service.buscarTodosOsInsumos(pageable);
		Mockito.verify(repository, Mockito.times(1)).findAll(pageable);
	}

	@Test
	@DisplayName("testando excluir insumo ☺")
	public void testando_excluir_Insumo() throws Exception {

		Optional<Insumo> in = Optional.of(insumo);

		Mockito.when(repository.findById(ArgumentMatchers.eq(insumoId))).thenReturn(in);
		service.excluirInsumo(insumoId);
		Mockito.verify(repository, Mockito.times(1)).delete(ArgumentMatchers.any(Insumo.class));
	}
}
