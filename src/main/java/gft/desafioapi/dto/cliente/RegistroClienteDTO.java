package gft.desafioapi.dto.cliente;

import javax.persistence.Embedded;

import gft.desafioapi.dto.endereco.EnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
public class RegistroClienteDTO {
	private String nome;
	private String email;
	private String cpf;
	@Embedded
	private EnderecoDTO endereco;
	
	
}
