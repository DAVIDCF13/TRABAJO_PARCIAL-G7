package com.upc.authjwt20251.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PuntosFidelidadDTO {
    private Long id;

    @NotNull(message = "El ID del usuario es obligatorio.")
    @Min(value = 1, message = "El ID del usuario debe ser un valor positivo.")
    private Long usuarioId;

    @NotNull(message = "Los puntos acumulados son obligatorios.")
    @PositiveOrZero(message = "Los puntos no pueden ser negativos.")
    private Integer puntosAcumulados;
}