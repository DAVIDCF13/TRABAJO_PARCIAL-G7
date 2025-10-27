package com.upc.authjwt20251.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaProductoDTO {
    private Long id;

    @NotBlank(message = "El nombre de la categoría es obligatorio y no puede estar vacío.")
    @Size(max = 50, message = "El nombre no puede exceder los 50 caracteres.")
    private String nombre;
    private List<Long> productoLocalIds;
}