package com.upc.authjwt20251.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoLocalDTO {
    private Long id;

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres.")
    private String nombre;

    @NotBlank(message = "La descripcion es obligatoria.")
    @Size(max = 500, message = "La descripcion no puede exceder los 500 caracteres.")
    private String descripcion;

    @NotNull(message = "El precio es obligatorio.")
    @Positive(message = "El precio debe ser un valor positivo.")
    private Double precio;

    @NotNull(message = "El ID de la categoría es obligatorio.")
    @Min(value = 1, message = "El ID de la categoría debe ser un valor positivo.")
    private Long categoriaProductoId;

    @NotNull(message = "El ID del proveedor es obligatorio.")
    @Min(value = 1, message = "El ID del proveedor debe ser un valor positivo.")
    private Long proveedorId;
}