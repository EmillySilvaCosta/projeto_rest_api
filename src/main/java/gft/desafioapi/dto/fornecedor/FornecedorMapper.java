package gft.desafioapi.dto.fornecedor;

import gft.desafioapi.dto.endereco.EnderecoMapper;
import gft.desafioapi.entities.Fornecedor;

public class FornecedorMapper {
    public static Fornecedor fromDTO(RegistroFornecedorDTO dto){
        return new Fornecedor(null, dto.getNome(), dto.getCnpj(), dto.getTempoMedioEntregaDias(), dto.getClassificacao(), EnderecoMapper.fromDTO(dto.getEndereco()), dto.getPecas(), dto.getInsumos(), dto.getVeiculos());
    }
    public static ConsultaFornecedorDTO fromEntity(Fornecedor fornecedor){
        return new ConsultaFornecedorDTO(fornecedor.getId(), fornecedor.getNome(), fornecedor.getCnpj(), fornecedor.getTempoMedioEntregaDias(),
                fornecedor.getClassificacao(), EnderecoMapper.fromEntity(fornecedor.getEndereco()), fornecedor.getPecas(), fornecedor.getInsumos(), fornecedor.getVeiculos());
    }
}
