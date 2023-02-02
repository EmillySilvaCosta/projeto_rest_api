package gft.desafioapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import gft.desafioapi.entities.Usuario;
import gft.desafioapi.repositories.UsuarioRepository;

@Service
@Transactional
public class AppUserDetailsService implements UserDetailsService {
    
    @Autowired(required=true)
	    private UsuarioRepository usuarioRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Usuario usuario = usuarioRepository.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
			return new User(usuario.getUsername(), usuario.getPassword(), true, true, true,true, usuario.getAuthorities());
		}
}
