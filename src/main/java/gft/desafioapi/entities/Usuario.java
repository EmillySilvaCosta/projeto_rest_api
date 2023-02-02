package gft.desafioapi.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_usuario")
public class Usuario implements Serializable, UserDetails{

	 private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(length = 15, nullable = false)
	    @NotBlank(message = "Username obrigatório")
	    @Length(min = 5, max = 80, message = "Username deve conter entre 5 e 15 caracteres")
	    private String username;

	    @Column(length = 250)
	    private String senha;


	    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinTable(name = "tb_acessos", joinColumns = @JoinColumn(
	            name = "usuario_id", referencedColumnName = "id"),
	            inverseJoinColumns = @JoinColumn(
	                    name = "perfil_id", referencedColumnName = "id"))
	    private List<Perfil> perfis;

	    

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return perfis;
	    }

	    @Override
	    public String getPassword() {
	        return senha;
	    }

	    @Override
	    public String getUsername() {
	        return username;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

}
