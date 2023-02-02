package gft.desafioapi.dto.peca;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;

import gft.desafioapi.entities.Fornecedor;
import gft.desafioapi.entities.Pedido;
import gft.desafioapi.entities.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistroPecaDTO {

	private String nome;
	private String origem;
	private int estoqueMinimo;
	private int estoqueMaximo;
	private int estoqueAtual;
	private Double valor;
	private String statusEstoque;
	
	@ManyToMany
    private List<Fornecedor> fornecedores = new ArrayList<>();
	
	@ManyToMany
	private List<Veiculo> veiculos = new ArrayList<>();

	@ManyToMany
	private List<Pedido> pedidos = new ArrayList<>();
}
