package gft.desafioapi.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import gft.desafioapi.entities.CepResponse;
import gft.desafioapi.entities.Cliente;
import gft.desafioapi.entities.Endereco;
import gft.desafioapi.repositories.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente salvarCliente(Cliente cliente) throws Exception {
		CepServiceImpl buscaCep = new CepServiceImpl();
		clienteRepository.save(cliente);
		CepResponse cep = buscaCep.buscaCep(cliente.getEndereco().getCep());
		cliente.setEndereco(new Endereco(cep.getLogradouro(), cliente.getEndereco().getNumero(), cliente.getEndereco().getComplemento(), cep.getCep()));

		return clienteRepository.save(cliente);
	}

	public List<Cliente> listarTodosOsClientes() {
		return clienteRepository.findAll();
	}

	public Cliente buscarCliente(Long id) {
		java.util.Optional<Cliente> optional = clienteRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Cliente não localizado!"));
	}
	
	public Cliente alterarCliente(Cliente cliente, Long id) {
		Cliente clienteOriginal = this.buscarCliente(id);
		cliente.setId_cliente(clienteOriginal.getId_cliente());
		
		return clienteRepository.save(cliente);
	}

	public void excluirCliente(Long id) {
		Cliente clienteOriginal = this.buscarCliente(id);
		
		clienteRepository.delete(clienteOriginal);
	}
}
