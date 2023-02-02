package gft.desafioapi.dto.pedido;

import gft.desafioapi.entities.Pedido;

public class PedidoMapper {
	public static Pedido fromDTO(RegistroPedidoDTO dto) {
		return new Pedido(null, dto.getVeiculos(), dto.getPecas(), dto.getValorTotal(), dto.getQtdTotal()
		, dto.getQtdTotalPecas(), dto.getQtdTotalVeiculos());
	}
	public static ConsultaPedidoDTO fromEntity(Pedido pedido) {
		return new ConsultaPedidoDTO(pedido.getId_pedido(), pedido.getVeiculos(),
		pedido.getPecas(), pedido.getValorTotal(), pedido.getQtdTotal(), pedido.getQtdTotalPecas()
		, pedido.getQtdTotalVeiculos());
	}

}
