package gft.desafioapi.dto.fornecedor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import gft.desafioapi.dto.endereco.EnderecoDTO;
import gft.desafioapi.entities.Classificacao;
import gft.desafioapi.entities.Insumo;
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
public class RegistroFornecedorDTO {

    private String nome;
    private String cnpj;

    private Integer tempoMedioEntregaDias;

    private Classificacao classificacao;

    private EnderecoDTO endereco;
    
    @ManyToMany
    private List<Peca> pecas = new ArrayList<>();

    @ManyToMany
    private List<Insumo> insumos = new ArrayList<>();

    @OneToMany
    private List<Veiculo> veiculos = new ArrayList<>();

}