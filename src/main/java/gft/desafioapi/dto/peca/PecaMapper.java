package gft.desafioapi.dto.peca;

import gft.desafioapi.entities.Peca;

public class PecaMapper {
//convertendo entidade para dto
	public static Peca fromDTO(RegistroPecaDTO dto) {
		
		return new Peca(null, dto.getNome(), dto.getOrigem(), dto.getEstoqueMinimo(), dto.getEstoqueMaximo(),dto.getEstoqueAtual(), dto.getValor(), dto.getStatusEstoque(), dto.getFornecedores(), dto.getVeiculos(), dto.getPedidos());
	}
	
	public static ConsultaPecaDTO fromEntity(Peca peca) {
		return new ConsultaPecaDTO(peca.getId_peca(), peca.getNome(), peca.getOrigem(), peca.getEstoqueMinimo(), peca.getEstoqueMaximo(),peca.getEstoqueAtual(), peca.getValor(), peca.getStatusEstoque(), peca.getFornecedores(), peca.getVeiculos(), peca.getPedidos());
	}

}
