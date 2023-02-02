package gft.desafioapi.dto.insumo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;

import gft.desafioapi.entities.Classificacao;
import gft.desafioapi.entities.Fornecedor;
import gft.desafioapi.entities.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistroInsumoDTO {
    
    private String nome_insumo;

    @ManyToMany
    private List<Fornecedor> fornecedores = new ArrayList<>();

    private Double valor_insumo;

    private Classificacao classificacao;

    @ManyToMany
    private List<Veiculo> veiculos = new ArrayList<>();   

    
}
