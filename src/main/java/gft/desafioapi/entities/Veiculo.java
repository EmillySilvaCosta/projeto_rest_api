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
@Table(name="tb_veiculo")
public class Veiculo implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_veiculo;
    private String nomeVeiculo;
    private String origemVeiculo;
    private int estoqueMinimoVeiculo;
    private int estoqueMaximoVeiculo;
    private int estoqueAtualVeiculo;
    @JsonIgnore
    @ManyToMany(mappedBy = "veiculos")
    private List<Peca> pecas = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "veiculos")
    private List<Insumo> insumos = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Fornecedor fornecedor;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "veiculos_pedidos", joinColumns = @JoinColumn(
            name = "veiculo_id", referencedColumnName = "id_veiculo"),
            inverseJoinColumns = @JoinColumn(
                    name = "pedido_id", referencedColumnName = "id_pedido"))
    private List<Pedido> pedidos = new ArrayList<>();

    private String statusVeiculo;
    private Double valorTotalPecasVeiculo;
    private Double valorTotalInsumosVeiculo;
    private Double valorTotalProducaoVeiculo;
    private Double valorTotalEstoqueGeralVeiculo;
    private Double porcentagemLucroVeiculo;
    private Double valorVendaFinalVeiculo;




    public Veiculo(Long id_veiculo, String nomeVeiculo, String origemVeiculo, int estoqueMinimoVeiculo,
            int estoqueMaximoVeiculo, int estoqueAtualVeiculo, List<Peca> pecas, List<Insumo> insumos,
            Fornecedor fornecedor, List<Pedido> pedidos, Double valorVendaFinalVeiculo) {
        this.id_veiculo = id_veiculo;
        this.nomeVeiculo = nomeVeiculo;
        this.origemVeiculo = origemVeiculo;
        this.estoqueMinimoVeiculo = estoqueMinimoVeiculo;
        this.estoqueMaximoVeiculo = estoqueMaximoVeiculo;
        this.estoqueAtualVeiculo = estoqueAtualVeiculo;
        this.pecas = pecas;
        this.insumos = insumos;
        this.fornecedor = fornecedor;
        this.pedidos = pedidos;
        this.valorVendaFinalVeiculo = valorVendaFinalVeiculo;
    }

    
    public void setId_veiculo(Long id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public void setOrigemVeiculo(String origemVeiculo) {
        this.origemVeiculo = origemVeiculo;
    }

    public void setEstoqueMinimoVeiculo(int estoqueMinimoVeiculo) {
        this.estoqueMinimoVeiculo = estoqueMinimoVeiculo;
    }

    public void setEstoqueMaximoVeiculo(int estoqueMaximoVeiculo) {
        this.estoqueMaximoVeiculo = estoqueMaximoVeiculo;
    }

    public void setEstoqueAtualVeiculo(int estoqueAtualVeiculo) {
        this.estoqueAtualVeiculo = estoqueAtualVeiculo;
    }

    public void setStatusVeiculo() {
        if(estoqueAtualVeiculo <= estoqueMinimoVeiculo){
            this.statusVeiculo = "ABAIXO, COMPRAR";
        }else if (estoqueAtualVeiculo > estoqueMaximoVeiculo){
            this.statusVeiculo = "ACIMA, VENDER";
        }else{
            this.statusVeiculo = "OK";
        }   
    }
    
    public void setValorTotalPecasVeiculo() {
        Double soma=0.0;
        if(pecas != null){
            for (Peca peca : pecas) {
                soma = soma + peca.getValor();
            }
            this.valorTotalPecasVeiculo = soma;
        }else{
            this.valorTotalPecasVeiculo = 0.0;
        }
    }

    public void setValorTotalInsumosVeiculo() {
        Double soma=0.0;
        if(insumos != null){
            for (Insumo insumo : insumos) {
                soma = soma + insumo.getValor_insumo();
            }
            this.valorTotalInsumosVeiculo = soma;
        }else{
            this.valorTotalInsumosVeiculo = 0.0;
        }
    }

    public void setValorTotalProducaoVeiculo() {
        this.valorTotalProducaoVeiculo = getValorTotalInsumosVeiculo() + getValorTotalInsumosVeiculo();
    }

    public void setValorTotalEstoqueGeralVeiculo() {
        this.valorTotalEstoqueGeralVeiculo = getEstoqueAtualVeiculo()*getValorTotalProducaoVeiculo();
    }

    public void setPorcentagemLucroVeiculo() {
        this.porcentagemLucroVeiculo = valorVendaFinalVeiculo - valorTotalProducaoVeiculo;
    }

    public void setValorvendaFinalVeiculo(Double valorvendaFinalVeiculo) {
        this.valorVendaFinalVeiculo = valorvendaFinalVeiculo;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public void setInsumos(List<Insumo> insumos) {
        this.insumos = insumos;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }


}
