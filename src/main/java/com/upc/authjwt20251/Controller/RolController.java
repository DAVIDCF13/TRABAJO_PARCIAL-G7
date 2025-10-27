package com.upc.authjwt20251.Controller;

import com.upc.authjwt20251.DTO.RolDTO;
import com.upc.authjwt20251.Service.RolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rol")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> listAll() {
        return new ResponseEntity<>(rolService.findAllDTO(), HttpStatus.OK);
    }

    @PostMapping("/inserta")
    public ResponseEntity<RolDTO> create(@Valid @RequestBody RolDTO dto) {
        return new ResponseEntity<>(rolService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/modifica/{id}")
    public ResponseEntity<RolDTO> update(@PathVariable Long id, @Valid @RequestBody RolDTO dto) {
        RolDTO updated = rolService.update(id, dto);

        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rolService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}