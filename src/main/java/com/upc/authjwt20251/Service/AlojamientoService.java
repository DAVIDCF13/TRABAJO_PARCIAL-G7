package com.upc.authjwt20251.Service;

import com.upc.authjwt20251.DTO.AlojamientoDTO;
import com.upc.authjwt20251.Entities.Alojamiento;
import com.upc.authjwt20251.Repository.AlojamientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlojamientoService {

    private final AlojamientoRepository alojamientoRepository;

    public AlojamientoService(AlojamientoRepository alojamientoRepository) {
        this.alojamientoRepository = alojamientoRepository;
    }

    public List<Alojamiento> findAll() {
        return alojamientoRepository.findAll();
    }

    public Alojamiento create(AlojamientoDTO dto) {
        Alojamiento alojamiento = new Alojamiento();
        alojamiento.setNombre(dto.getNombre());
        alojamiento.setPrecio(dto.getPrecioPorNoche());
        return alojamientoRepository.save(alojamiento);
    }

    public Alojamiento update(Long id, AlojamientoDTO dto) {
        Alojamiento buscado = alojamientoRepository.findById(id).orElse(null);
        if (buscado != null) {
            buscado.setNombre(dto.getNombre());
            buscado.setPrecio(dto.getPrecioPorNoche());
            return alojamientoRepository.save(buscado);
        }
        return null;
    }
}