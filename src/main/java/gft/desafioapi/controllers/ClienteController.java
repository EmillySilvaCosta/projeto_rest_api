package gft.desafioapi.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.desafioapi.dto.cliente.ClienteMapper;
import gft.desafioapi.dto.cliente.ConsultaClienteDTO;
import gft.desafioapi.dto.cliente.RegistroClienteDTO;
import gft.desafioapi.entities.Cliente;
import gft.desafioapi.services.ClienteService;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

	private ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@GetMapping
	public ResponseEntity<List<Object>> buscarTodosOsClientes() {

		return ResponseEntity.ok(clienteService.listarTodosOsClientes().stream().map(ClienteMapper::fromEntity)
				.collect(Collectors.toList()));
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@PostMapping
	public ResponseEntity<ConsultaClienteDTO> salvarCliente(@RequestBody RegistroClienteDTO dto) throws Exception {
		Cliente cliente = clienteService.salvarCliente(ClienteMapper.fromDTO(dto));

		return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@GetMapping("{id}")
	public ResponseEntity<ConsultaClienteDTO> buscarCliente(@PathVariable Long id) {
		try {
			Cliente cliente = clienteService.buscarCliente(id);
			return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@PutMapping("{id}")
	public ResponseEntity<ConsultaClienteDTO> alterarCliente(@RequestBody RegistroClienteDTO dto, @PathVariable Long id) {
		try {
			Cliente cliente = clienteService.alterarCliente(ClienteMapper.fromDTO(dto), id);
			return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaClienteDTO> excluirCliente(@PathVariable Long id) {
		try {
			clienteService.excluirCliente(id);
			
			return ResponseEntity.ok().build();
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
}
