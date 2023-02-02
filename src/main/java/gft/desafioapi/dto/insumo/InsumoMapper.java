package gft.desafioapi.dto.insumo;

import gft.desafioapi.entities.Insumo;

public class InsumoMapper {
    
    public static Insumo fromDTO(RegistroInsumoDTO dto){
        return new Insumo(null, dto.getNome_insumo(), dto.getFornecedores(), dto.getValor_insumo(), dto.getClassificacao(), dto.getVeiculos());
    }

    public static ConsultaInsumoDTO fromEntity(Insumo insumo){
        return new ConsultaInsumoDTO(insumo.getId_insumo(), insumo.getNome_insumo(), insumo.getFornecedores(), insumo.getValor_insumo(), insumo.getClassificacao(), insumo.getVeiculos());
    }
}
