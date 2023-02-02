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

import gft.desafioapi.entities.Fornecedor;
import gft.desafioapi.repositories.FornecedorRepository;
import gft.desafioapi.services.FornecedorService;

public class FornecedorServiceTest extends AplicationConfigTest {

	private Long fornecedorId = 1l;

	@Autowired
	private FornecedorService service;

	@MockBean
	private FornecedorRepository repository;

	@MockBean
	private Fornecedor fornecedor;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	/*@Test
	@DisplayName("testando salvar fornecedor ☺")
	public void salvar_Fornecedor() throws Exception {

		Fornecedor fornecedor = Mockito.mock(Fornecedor.class);
		service.salvarFornecedorTest(fornecedor);
		Mockito.verify(repository, Mockito.times(1)).save(ArgumentMatchers.any(Fornecedor.class));
	}*/

//	@Test
//	@DisplayName("testando listar fornecedores ☺")
//	public void testando_listar_fornecedores() throws Exception {
//		Pageable pageable = null;
//		service.listarTodosOsFornecedores(pageable);
//		Mockito.verify(repository, Mockito.times(1)).findAll((ArgumentMatchers.any(Pageable.class)));
//	}
//
//	@Test
//	@DisplayName("testando alterar fornecedor ☺")
//	public void testando_alterar_fornecedor() throws Exception {
//		Fornecedor fornecedor = Mockito.mock(Fornecedor.class);
//		service.alterarFornecedor(fornecedor, fornecedorId);
//		Mockito.verify(repository, Mockito.times(1)).findById(ArgumentMatchers.any(Fornecedor.class).getId());
//	}

	@Test
	@DisplayName("testando excluir fornecedor ☺")
	public void testando_excluir_Fornecedor() throws Exception {

		Optional<Fornecedor> fo = Optional.of(fornecedor);

		Mockito.when(repository.findById(ArgumentMatchers.eq(fornecedorId))).thenReturn(fo);
		service.excluirFornecedor(fornecedorId);
		Mockito.verify(repository, Mockito.times(1)).delete(ArgumentMatchers.any(Fornecedor.class));
	}

}
