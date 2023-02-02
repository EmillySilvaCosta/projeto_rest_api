package gft.desafioapi.dto.cliente;

import gft.desafioapi.dto.endereco.EnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
public class ConsultaClienteDTO {
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private EnderecoDTO endereco;
	
	
}
