package com.upc.authjwt20251.Service;

import com.upc.authjwt20251.DTO.PaqueteTuristicoDTO;
import com.upc.authjwt20251.Entities.PaqueteTuristico;
import com.upc.authjwt20251.Repository.PaqueteTuristicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaqueteTuristicoService {

    private final PaqueteTuristicoRepository repository;

    public PaqueteTuristicoService(PaqueteTuristicoRepository repository) {
        this.repository = repository;
    }

    private PaqueteTuristicoDTO toDTO(PaqueteTuristico p) {
        if (p == null) return null;
        PaqueteTuristicoDTO dto = new PaqueteTuristicoDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setPrecio(p.getPrecio());

        dto.setReservaId(p.getReservas() != null ? (long) p.getReservas().size() : 0L);
        dto.setPromocionId(p.getPromociones() != null ? (long) p.getPromociones().size() : 0L);
        dto.setPaqueteActividadId(p.getPaquetesActividad() != null ? (long) p.getPaquetesActividad().size() : 0L);

        return dto;
    }

    private PaqueteTuristico toEntity(PaqueteTuristicoDTO dto) {
        PaqueteTuristico p = new PaqueteTuristico();
        p.setNombre(dto.getNombre());
        p.setPrecio(dto.getPrecio());

        return p;
    }

    public List<PaqueteTuristicoDTO> findAllDTO() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public PaqueteTuristicoDTO create(PaqueteTuristicoDTO dto) {
        PaqueteTuristico pToSave = toEntity(dto);
        PaqueteTuristico saved = repository.save(pToSave);

        return toDTO(saved);
    }

    public PaqueteTuristicoDTO update(Long id, PaqueteTuristicoDTO dto) {
        PaqueteTuristico p = repository.findById(id).orElse(null);

        if (p != null) {
            p.setNombre(dto.getNombre());
            p.setPrecio(dto.getPrecio());

            PaqueteTuristico updated = repository.save(p);
            return toDTO(updated);
        }
        return null;
    }
}