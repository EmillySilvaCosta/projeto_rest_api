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
@Table(name = "tb_pedido")
public class Pedido implements Serializable{
    
	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;

    
    @JsonIgnore
    @ManyToMany(mappedBy = "pedidos")                
	private List<Veiculo> veiculos = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "pedidos")
    private List<Peca> pecas = new ArrayList<>();

    private Double valorTotal;

    private int qtdTotal;

    private int qtdTotalPecas;

    private int qtdTotalVeiculos;

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public void setValorTotal() {
        Double soma = 0.0;
        if(pecas != null){
            for (Peca peca : pecas) {
                soma += peca.getValor();
            }
        }

        if(veiculos != null){
            for (Veiculo veiculo : veiculos ) {
                soma += veiculo.getValorVendaFinalVeiculo();
            }
        }
        this.valorTotal = soma;
    }

    public void setQtdTotal() {
        int soma = 0;
        if(pecas != null){
            soma += pecas.size();
        }

        if(veiculos != null) {
            soma += veiculos.size();
        }
        this.qtdTotal = soma;
    }

    public void setQtdTotalPecas() {
        int soma = 0;
        if(pecas != null){
            soma += pecas.size();
        }
        this.qtdTotalPecas = soma;
    }

    public void setQtdTotalVeiculos() {
        int soma = 0;
        if(veiculos != null) {
            soma += veiculos.size();
        }
        
        this.qtdTotalVeiculos = soma;
    }

   
}
