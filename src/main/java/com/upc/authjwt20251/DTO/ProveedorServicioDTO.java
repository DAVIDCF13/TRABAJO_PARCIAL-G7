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
public class ProveedorServicioDTO {
    private Long id;

    @NotBlank(message = "El nombre del proveedor es obligatorio.")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres.")
    private String nombre;

    @NotBlank(message = "El contacto es obligatorio.")
    @Size(max = 100, message = "El contacto no puede exceder los 100 caracteres.")
    private String contacto;

    private List<Long> productoLocalIds;
}