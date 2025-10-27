package com.upc.authjwt20251.Service;

import com.upc.authjwt20251.DTO.UsuarioDTO;
import com.upc.authjwt20251.Entities.Rol;
import com.upc.authjwt20251.Entities.Usuario;
import com.upc.authjwt20251.Repository.RolRepository;
import com.upc.authjwt20251.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario create(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setEnabled(dto.getEnabled());

        Rol rol = rolRepository.findById(dto.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        usuario.setRol(rol);

        return usuarioRepository.save(usuario);
    }

    public Usuario update(Long id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setUsername(dto.getUsername());
            usuario.setPassword(dto.getPassword());
            usuario.setEnabled(dto.getEnabled());

            Rol rol = rolRepository.findById(dto.getRolId())
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
            usuario.setRol(rol);

            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}