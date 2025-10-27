package com.upc.authjwt20251.Service;

import com.upc.authjwt20251.DTO.PaqueteActividadDTO;
import com.upc.authjwt20251.Entities.PaqueteActividad;
import com.upc.authjwt20251.Repository.ActividadRepository;
import com.upc.authjwt20251.Repository.PaqueteActividadRepository;
import com.upc.authjwt20251.Repository.PaqueteTuristicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaqueteActividadService {

    private final PaqueteActividadRepository repository;
    private final ActividadRepository actividadRepository;
    private final PaqueteTuristicoRepository paqueteTuristicoRepository;


    public PaqueteActividadService(PaqueteActividadRepository repository,
                                   ActividadRepository actividadRepository,
                                   PaqueteTuristicoRepository paqueteTuristicoRepository) {
        this.repository = repository;
        this.actividadRepository = actividadRepository;
        this.paqueteTuristicoRepository = paqueteTuristicoRepository;
    }

    private PaqueteActividadDTO toDTO(PaqueteActividad p) {
        if (p == null) return null;
        PaqueteActividadDTO dto = new PaqueteActividadDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setPrecio(p.getPrecio());

        dto.setPaqueteTuristicoId(p.getPaqueteTuristico() != null ? p.getPaqueteTuristico().getId() : null);

        dto.setActividadId(p.getActividades() != null && !p.getActividades().isEmpty()
                ? p.getActividades().get(0).getId()
                : null);

        return dto;
    }

    private PaqueteActividad toEntity(PaqueteActividadDTO dto) {
        PaqueteActividad p = new PaqueteActividad();
        p.setNombre(dto.getNombre());
        p.setPrecio(dto.getPrecio());

        p.setPaqueteTuristico(paqueteTuristicoRepository.findById(dto.getPaqueteTuristicoId()).orElse(null));

        return p;
    }

    public List<PaqueteActividadDTO> findAllDTO() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PaqueteActividadDTO create(PaqueteActividadDTO dto) {
        PaqueteActividad pToSave = toEntity(dto);
        PaqueteActividad saved = repository.save(pToSave);

        return toDTO(saved);
    }

    public PaqueteActividadDTO update(Long id, PaqueteActividadDTO dto) {
        PaqueteActividad p = repository.findById(id).orElse(null);

        if (p != null) {
            p.setNombre(dto.getNombre());
            p.setPrecio(dto.getPrecio());

            p.setPaqueteTuristico(paqueteTuristicoRepository.findById(dto.getPaqueteTuristicoId()).orElse(null));

            PaqueteActividad updated = repository.save(p);
            return toDTO(updated);
        }
        return null;
    }
}