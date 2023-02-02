package gft.desafioapi.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import gft.desafioapi.entities.Pedido;
import gft.desafioapi.repositories.PedidoRepository;

@Service
public class PedidoService {
    private PedidoRepository pedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	public Pedido salvarPedido(Pedido pedido) {
		pedidoRepository.save(pedido);

		pedido.setQtdTotal();
		pedido.setQtdTotalPecas();
		pedido.setQtdTotalVeiculos();
		pedido.setValorTotal();

		return pedidoRepository.save(pedido);
	}

	public List<Pedido> listarTodosOsPedidos() {
		return pedidoRepository.findAll();
	}

	public Pedido buscarPedido(Long id) {
		Optional<Pedido> optional = pedidoRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Pedido não localizado!"));
	}
	
	public Pedido atualizarPedido(Pedido pedido, Long id) {
		Pedido clienteOriginal = this.buscarPedido(id);
		pedido.setId_pedido(clienteOriginal.getId_pedido());
		
		return pedidoRepository.save(pedido);
	}

	public void excluirPedido(Long id) {
		Pedido pedidoOriginal = this.buscarPedido(id);
		
		pedidoRepository.delete(pedidoOriginal);
	}
}
