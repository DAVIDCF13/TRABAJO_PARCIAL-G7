package com.upc.authjwt20251.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistorialPuntosDTO {
    private Long id;
    private Long usuarioId;

    @NotNull(message = "El campo puntos es obligatorio.")
    @Positive(message = "El valor de los puntos debe ser mayor a cero.")
    private Integer puntos;

    @NotNull(message = "La fecha es obligatoria.")
    @FutureOrPresent(message = "La fecha no puede ser pasada.")
    private LocalDate fecha;
}