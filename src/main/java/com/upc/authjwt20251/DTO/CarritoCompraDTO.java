package com.upc.authjwt20251.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarritoCompraDTO {
    private Long id;

    @NotNull(message = "El ID del usuario es obligatorio.")
    @Min(value = 1, message = "El ID del usuario debe ser un valor positivo.")
    private Long usuarioId;

    @Valid
    private List<DetalleCarritoDTO> detalles;
}