package com.upc.authjwt20251.Service;

import com.upc.authjwt20251.DTO.RolDTO;
import com.upc.authjwt20251.Entities.Rol;
import com.upc.authjwt20251.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;
    private RolDTO convertToDto(Rol rol) {
        if (rol == null) return null;
        RolDTO dto = new RolDTO();
        dto.setId(rol.getId());
        dto.setNombre(rol.getNombre());
        return dto;
    }

    private Rol convertToEntity(RolDTO dto) {
        if (dto == null) return null;
        Rol rol = new Rol();
        rol.setNombre(dto.getNombre());
        return rol;
    }

    public List<RolDTO> findAllDTO() {
        return rolRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public RolDTO create(RolDTO dto) {
        Rol rolToSave = convertToEntity(dto);
        Rol savedRol = rolRepository.save(rolToSave);
        return convertToDto(savedRol);
    }

    public RolDTO update(Long id, RolDTO dto) {
        Rol rol = rolRepository.findById(id).orElse(null);

        if (rol != null) {
            rol.setNombre(dto.getNombre());
            Rol updatedRol = rolRepository.save(rol);
            return convertToDto(updatedRol);
        }
        return null;
    }

    public void delete(Long id) {
        rolRepository.deleteById(id);
    }
}