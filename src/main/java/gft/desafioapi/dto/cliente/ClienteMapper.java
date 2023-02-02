package gft.desafioapi.dto.cliente;

import gft.desafioapi.dto.endereco.EnderecoMapper;
import gft.desafioapi.entities.Cliente;

public class ClienteMapper {
	public static Cliente fromDTO(RegistroClienteDTO dto) {

		return new Cliente(null, dto.getNome(), dto.getEmail(), dto.getCpf(),
				EnderecoMapper.fromDTO(dto.getEndereco()));
	}

	public static ConsultaClienteDTO fromEntity(Cliente cliente) {
		return new ConsultaClienteDTO(cliente.getId_cliente(), cliente.getNome(), cliente.getEmail(), cliente.getCpf(),
				EnderecoMapper.fromEntity(cliente.getEndereco()));
	}

}
