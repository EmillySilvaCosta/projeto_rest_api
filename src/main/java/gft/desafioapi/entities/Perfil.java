package gft.desafioapi.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_perfil")
public class Perfil implements Serializable, GrantedAuthority{

	private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(length = 30, nullable = false)
	    private String nome;

	    @ManyToMany(mappedBy = "perfis")
	    private List<Usuario> usuarios;

	    @Override
	    public String getAuthority() {
	        return nome;
	    }

	
}

