package gft.desafioapi.dto.veiculo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import gft.desafioapi.entities.Fornecedor;
import gft.desafioapi.entities.Insumo;
import gft.desafioapi.entities.Peca;
import gft.desafioapi.entities.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaVeiculoDTO {
     
    private Long id_veiculo;

    private String nomeVeiculo;
    private String origemVeiculo;
    private int estoqueMinimoVeiculo;
    private int estoqueMaximoVeiculo;
    private int estoqueAtualVeiculo;
    private Double valorVendaFinalVeiculo;

    @ManyToMany
    private List<Peca> pecas = new ArrayList<>();

    @ManyToMany
    private List<Insumo> insumos = new ArrayList<>();

    @ManyToOne
    private Fornecedor fornecedor;

    @ManyToMany
    private List<Pedido> pedidos = new ArrayList<>();
    
}
