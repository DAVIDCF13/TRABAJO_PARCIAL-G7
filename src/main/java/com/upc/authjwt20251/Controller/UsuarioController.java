package com.upc.authjwt20251.Controller;

import com.upc.authjwt20251.DTO.UsuarioDTO;
import com.upc.authjwt20251.Entities.Usuario;
import com.upc.authjwt20251.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> listAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        List<Map<String, Object>> response = new ArrayList<>();

        for (Usuario u : usuarios) {
            Map<String, Object> resp = new LinkedHashMap<>();
            resp.put("id", u.getId());
            resp.put("username", u.getUsername());
            resp.put("password", u.getPassword());
            resp.put("enabled", u.getEnabled());
            resp.put("rolId", u.getRol().getId());
            response.add(resp);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/inserta")
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody UsuarioDTO dto) {
        Usuario u = usuarioService.create(dto);

        Map<String, Object> resp = new LinkedHashMap<>();
        resp.put("id", u.getId());
        resp.put("username", u.getUsername());
        resp.put("password", u.getPassword());
        resp.put("enabled", u.getEnabled());
        resp.put("rolId", u.getRol().getId());

        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @PutMapping("/modifica/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @Valid @RequestBody UsuarioDTO dto) {
        Usuario u = usuarioService.update(id, dto);

        if (u == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Map<String, Object> resp = new LinkedHashMap<>();
        resp.put("id", u.getId());
        resp.put("username", u.getUsername());
        resp.put("password", u.getPassword());
        resp.put("enabled", u.getEnabled());
        resp.put("rolId", u.getRol().getId());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}