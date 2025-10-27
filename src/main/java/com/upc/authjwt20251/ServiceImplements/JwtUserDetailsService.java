package com.upc.authjwt20251.ServiceImplements;

import com.upc.authjwt20251.Entities.Usuario;
import com.upc.authjwt20251.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        // Crear lista de roles
        List<GrantedAuthority> roles = new ArrayList<>();
        // Agregar el rol con prefijo ROLE_ para Spring Security
        roles.add(new SimpleGrantedAuthority("ROLE_" + user.getRol().getNombre()));

        // Construir UserDetails con username, password (BCrypt) y roles
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                true, // accountNonExpired
                true, // credentialsNonExpired
                true, // accountNonLocked
                roles
        );
    }
}