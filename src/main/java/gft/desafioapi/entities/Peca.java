package gft.desafioapi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor 
@NoArgsConstructor
@Table(name = "tb_peca")
public class Peca implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_peca;
	
	private String nome;
	private String origem;
	private int estoqueMinimo;
	private int estoqueMaximo;
	private int estoqueAtual;
	private Double valor;
	private String statusEstoque;

	@ManyToMany(mappedBy = "pecas")
    @JsonIgnore
    private List<Fornecedor> fornecedores = new ArrayList<>();

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "pecas_veiculos", joinColumns = @JoinColumn(
            name = "peca_id", referencedColumnName = "id_peca"),
            inverseJoinColumns = @JoinColumn(
                    name = "veiculo_id", referencedColumnName = "id_veiculo"))
	private List<Veiculo> veiculos = new ArrayList<>();

	
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "pecas_pedidos", joinColumns = @JoinColumn(name = "peca_id", referencedColumnName = "id_peca"), inverseJoinColumns = @JoinColumn(name = "pedido_id", referencedColumnName = "id_pedido"))
	private List<Pedido> pedidos = new ArrayList<>();


	public void setId_peca(Long id_peca) {
		this.id_peca = id_peca;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}


	public void setEstoqueMaximo(int estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}


	public void setEstoqueAtual(int estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public void setStatusEstoque() {
		if(estoqueAtual <= estoqueMinimo){
            this.statusEstoque = "ABAIXO, COMPRAR";
        }else if (estoqueAtual > estoqueMaximo){
            this.statusEstoque = "ACIMA, VENDER";
        }else{
            this.statusEstoque = "OK";
        }   
	}


	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}


	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}


	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	
	
}
