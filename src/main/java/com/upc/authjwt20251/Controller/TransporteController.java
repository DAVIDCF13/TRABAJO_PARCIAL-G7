package com.upc.authjwt20251.Controller;

import com.upc.authjwt20251.DTO.TransporteDTO;
import com.upc.authjwt20251.Service.TransporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transporte")
@CrossOrigin
public class TransporteController {

    private final TransporteService transporteService;

    public TransporteController(TransporteService transporteService) {
        this.transporteService = transporteService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('TURISTA','ADMINISTRADOR')")
    public ResponseEntity<List<TransporteDTO>> findAll() {
        return new ResponseEntity<>(transporteService.findAllDTO(), HttpStatus.OK);
    }

    @PostMapping("/inserta")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<TransporteDTO> create(@Valid @RequestBody TransporteDTO dto) {
        return new ResponseEntity<>(transporteService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/modifica/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<TransporteDTO> update(@PathVariable Long id, @Valid @RequestBody TransporteDTO dto) {
        TransporteDTO updated = transporteService.update(id, dto);

        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}