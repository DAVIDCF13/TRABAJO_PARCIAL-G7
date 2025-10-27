package com.upc.authjwt20251.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleCarritoDTO {
    private Long id;

    @NotNull(message = "El ID del carrito es obligatorio.")
    @Min(value = 1, message = "El ID del carrito debe ser un valor positivo.")
    private Long carritoCompraId;

    @NotNull(message = "El ID del producto local es obligatorio.")
    @Min(value = 1, message = "El ID del producto local debe ser un valor positivo.")
    private Long productoLocalId;

    @NotNull(message = "La cantidad es obligatoria.")
    @Min(value = 1, message = "La cantidad minima debe ser 1.")
    private Integer cantidad;
}