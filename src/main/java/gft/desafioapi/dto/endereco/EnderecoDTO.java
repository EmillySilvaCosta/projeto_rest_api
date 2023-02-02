package gft.desafioapi.dto.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
    
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    
}
