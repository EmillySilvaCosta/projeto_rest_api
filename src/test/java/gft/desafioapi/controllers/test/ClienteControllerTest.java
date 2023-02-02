package gft.desafioapi.controllers.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import gft.desafioapi.repositories.ClienteRepository;
import gft.desafioapi.services.ClienteService;
import gft.desafioapi.services.test.AplicationConfigTest;


public class ClienteControllerTest extends AplicationConfigTest {

	@Autowired
	MockMvc mockMvc;
	
//	@Autowired
//	private ObjectMapper objectMapper;
	
	@MockBean
	private ClienteService service;
	
	@MockBean
	private ClienteRepository repository;
	
	//private static final String PATH = "/v1/clientes";
	
	/*@Test
	@DisplayName("testando endpoint ☺")
	public void teste_para_ver_caminho() throws Exception{
		mockMvc.perform(get("/v1/clientes"))
		.andExpect(status().isOk());
	}*/
	
	/*@Test
	@DisplayName("fazendo post de um cliente ☺")
	public void testando_post() throws Exception{
	    long id = 1; String nome = "Amanda"; String email = "amanda@gft.com";
	    String cpf = "04415781390"; Endereco endereco = null;
	    Cliente cliente;
	    cliente = new Cliente(id,nome, email, cpf, endereco);
	    
	    String json = new ObjectMapper().writeValueAsString(cliente);
	    
	    mockMvc.perform(MockMvcRequestBuilders.post(PATH)
	    		.contentType(MediaType.APPLICATION_JSON)
	    		.content(json))
	    		.andExpect(status().isOk());
	    	
	    verify(service, times(1)).salvarCliente((Cliente) any(RegistroClienteDTO.class));
	    
	}*/
	
}
