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
@Table(name = "tb_fornecedor")
public class Fornecedor implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        private String nome;
        
        private String cnpj;
        
        private Integer tempoMedioEntregaDias;

        @Enumerated(EnumType.STRING)
        private Classificacao classificacao;

        @Embedded
        private Endereco endereco;

        @JsonIgnore
        @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JoinTable(name = "pecas_fornecedores", joinColumns = 
        @JoinColumn(name = "fornecedor_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "peca_id", referencedColumnName = "id_peca"))
        private List<Peca> pecas = new ArrayList<>();

        @JsonIgnore
        @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinTable(name = "insumos_fornecedores", joinColumns = 
        @JoinColumn(name = "fornecedor_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "insumos_id", referencedColumnName = "id_insumo"))
        private List<Insumo> insumos = new ArrayList<>();

        @JsonIgnore
        @OneToMany(mappedBy = "fornecedor")
        private List<Veiculo> veiculos = new ArrayList<>();

}
