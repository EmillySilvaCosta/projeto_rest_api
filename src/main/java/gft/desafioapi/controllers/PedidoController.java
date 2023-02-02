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

import gft.desafioapi.dto.pedido.ConsultaPedidoDTO;
import gft.desafioapi.dto.pedido.PedidoMapper;
import gft.desafioapi.dto.pedido.RegistroPedidoDTO;
import gft.desafioapi.entities.Pedido;
import gft.desafioapi.services.PedidoService;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidoController {
    
    private PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@GetMapping
	public ResponseEntity<List<Object>> buscarTodosOsPedidos() {

		return ResponseEntity.ok(pedidoService.listarTodosOsPedidos().stream().map(PedidoMapper::fromEntity)
				.collect(Collectors.toList()));
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@PostMapping
	public ResponseEntity<ConsultaPedidoDTO> salvarPedido(@RequestBody RegistroPedidoDTO dto) {
		Pedido pedido = pedidoService.salvarPedido(PedidoMapper.fromDTO(dto));

		return ResponseEntity.ok(PedidoMapper.fromEntity(pedido));
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@GetMapping("{id}")
	public ResponseEntity<ConsultaPedidoDTO> buscarPedido(@PathVariable Long id) {
		try {
			Pedido pedido = pedidoService.buscarPedido(id);
			return ResponseEntity.ok(PedidoMapper.fromEntity(pedido));
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@PutMapping("{id}")
	public ResponseEntity<ConsultaPedidoDTO> alterarPedido(@RequestBody RegistroPedidoDTO dto, @PathVariable Long id) {
		try {
			Pedido pedido = pedidoService.atualizarPedido(PedidoMapper.fromDTO(dto), id);
			return ResponseEntity.ok(PedidoMapper.fromEntity(pedido));
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaPedidoDTO> excluirPedido(@PathVariable Long id) {
		try {
			pedidoService.excluirPedido(id);
			
			return ResponseEntity.ok().build();
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
}
