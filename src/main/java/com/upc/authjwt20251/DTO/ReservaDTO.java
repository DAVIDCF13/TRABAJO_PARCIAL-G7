package com.upc.authjwt20251.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {
    private Long id;

    @NotNull(message = "El ID del alojamiento es obligatorio.")
    @Min(value = 1, message = "El ID del alojamiento debe ser un valor positivo.")
    private Long alojamientoId;

    @NotNull(message = "El ID del paquete turístico es obligatorio.")
    @Min(value = 1, message = "El ID del paquete turístico debe ser un valor positivo.")
    private Long paqueteTuristicoId;

    @NotNull(message = "El ID del transporte es obligatorio.")
    @Min(value = 1, message = "El ID del transporte debe ser un valor positivo.")
    private Long transporteId;

    @NotNull(message = "La fecha de reserva es obligatoria.")
    @FutureOrPresent(message = "La fecha de reserva no puede ser pasada.")
    private LocalDate fecha;

    @NotNull(message = "La cantidad de personas es obligatoria.")
    @Min(value = 1, message = "Debe haber al menos 1 persona en la reserva.")
    private Integer cantidadPersonas;
}