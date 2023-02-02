package gft.desafioapi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
@Table(name = "tb_insumo")
public class Insumo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_insumo;

    private String nome_insumo;

    
    @JsonIgnore
    @ManyToMany(mappedBy = "insumos")
    private List<Fornecedor> fornecedores = new ArrayList<>();

    private Double valor_insumo;

    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "insumos_veiculos", joinColumns = @JoinColumn(
            name = "insumo_id", referencedColumnName = "id_insumo"),
            inverseJoinColumns = @JoinColumn(
                    name = "veiculo_id", referencedColumnName = "id_veiculo"))
	private List<Veiculo> veiculos = new ArrayList<>();

}