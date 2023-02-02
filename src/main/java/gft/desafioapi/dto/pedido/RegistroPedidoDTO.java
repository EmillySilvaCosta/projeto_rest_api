package gft.desafioapi.dto.pedido;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;


import gft.desafioapi.entities.Peca;
import gft.desafioapi.entities.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistroPedidoDTO {

    @ManyToMany             
	private List<Veiculo> veiculos = new ArrayList<>();

    @ManyToMany
    private List<Peca> pecas = new ArrayList<>();

    private Double valorTotal;

    private int qtdTotal;

    private int qtdTotalPecas;

    private int qtdTotalVeiculos;
}
