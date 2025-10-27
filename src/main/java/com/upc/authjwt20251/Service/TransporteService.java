package com.upc.authjwt20251.Service;

import com.upc.authjwt20251.DTO.TransporteDTO;
import com.upc.authjwt20251.Entities.Reserva;
import com.upc.authjwt20251.Entities.Transporte;
import com.upc.authjwt20251.Repository.PaqueteTuristicoRepository;
import com.upc.authjwt20251.Repository.ReservaRepository;
import com.upc.authjwt20251.Repository.TransporteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransporteService {

    private final TransporteRepository transporteRepository;
    private final PaqueteTuristicoRepository paqueteRepository;
    private final ReservaRepository reservaRepository;

    public TransporteService(TransporteRepository transporteRepository,
                             PaqueteTuristicoRepository paqueteRepository,
                             ReservaRepository reservaRepository) {
        this.transporteRepository = transporteRepository;
        this.paqueteRepository = paqueteRepository;
        this.reservaRepository = reservaRepository;
    }

    public List<TransporteDTO> findAllDTO() {
        List<Transporte> transportes = transporteRepository.findAll();
        List<TransporteDTO> result = new ArrayList<>();

        for (Transporte t : transportes) {
            TransporteDTO dto = new TransporteDTO();
            dto.setTipo(t.getTipo());
            dto.setEmpresa(t.getEmpresa());
            dto.setPrecio(t.getPrecio());
            if (!t.getReservas().isEmpty()) {
                dto.setReservaId(t.getReservas().get(0).getId());
                dto.setPaqueteTuristicoId(t.getReservas().get(0).getPaqueteTuristico().getId());
            }
            result.add(dto);
        }

        return result;
    }

    public TransporteDTO create(TransporteDTO dto) {
        Transporte transporte = new Transporte();
        transporte.setTipo(dto.getTipo());
        transporte.setEmpresa(dto.getEmpresa());
        transporte.setPrecio(dto.getPrecio());

        if (dto.getReservaId() != null) {
            Reserva reserva = reservaRepository.findById(dto.getReservaId())
                    .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
            reserva.setTransporte(transporte);
            transporte.setReservas(List.of(reserva));
        }

        paqueteRepository.findById(dto.getPaqueteTuristicoId())
                .orElseThrow(() -> new RuntimeException("Paquete turístico no encontrado"));

        transporteRepository.save(transporte);

        dto.setReservaId(dto.getReservaId());
        dto.setPaqueteTuristicoId(dto.getPaqueteTuristicoId());
        return dto;
    }

    public TransporteDTO update(Long id, TransporteDTO dto) {
        Transporte buscado = transporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transporte no encontrado"));

        buscado.setTipo(dto.getTipo());
        buscado.setEmpresa(dto.getEmpresa());
        buscado.setPrecio(dto.getPrecio());

        if (dto.getReservaId() != null) {
            Reserva reserva = reservaRepository.findById(dto.getReservaId())
                    .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
            reserva.setTransporte(buscado);
            buscado.setReservas(List.of(reserva));
        }

        transporteRepository.save(buscado);

        dto.setReservaId(dto.getReservaId());
        dto.setPaqueteTuristicoId(dto.getPaqueteTuristicoId());
        return dto;
    }
}