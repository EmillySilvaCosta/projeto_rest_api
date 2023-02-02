package gft.desafioapi.dto.veiculo;

import gft.desafioapi.entities.Veiculo;

public class VeiculoMapper {
    
    public static Veiculo fromDTO(RegistroVeiculoDTO dto) {
		return new Veiculo(null, dto.getNomeVeiculo(), dto.getOrigemVeiculo(), 
		dto.getEstoqueMinimoVeiculo(), dto.getEstoqueMaximoVeiculo(), 
		dto.getEstoqueAtualVeiculo(), dto.getPecas(), dto.getInsumos(), dto.getFornecedor(), dto.getPedidos(), dto.getValorVendaFinalVeiculo());
	}
	
	public static ConsultaVeiculoDTO fromEntity(Veiculo veiculo) {
		return new ConsultaVeiculoDTO(veiculo.getId_veiculo(), veiculo.getNomeVeiculo(),
		 veiculo.getOrigemVeiculo(), veiculo.getEstoqueMinimoVeiculo(), veiculo.getEstoqueMaximoVeiculo(),
		 veiculo.getEstoqueAtualVeiculo(), veiculo.getValorVendaFinalVeiculo(), veiculo.getPecas(), veiculo.getInsumos(), veiculo.getFornecedor(), veiculo.getPedidos());
	}
}
