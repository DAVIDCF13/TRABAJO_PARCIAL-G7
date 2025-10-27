package com.upc.authjwt20251.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaqueteTuristicoDTO {
    private Long id;

    @NotBlank(message = "El nombre del paquete es obligatorio.")
    @Size(max = 150, message = "El nombre no puede exceder los 150 caracteres.")
    private String nombre;

    @NotNull(message = "El precio es obligatorio.")
    @Positive(message = "El precio debe ser un valor positivo.")
    private Double precio;

    @NotNull(message = "El ID de la reserva es obligatorio.")
    @Min(value = 1, message = "El ID de la reserva debe ser un valor positivo.")
    private Long reservaId;

    @NotNull(message = "El ID de la promocion es obligatorio.")
    @Min(value = 1, message = "El ID de la promoción debe ser un valor positivo.")
    private Long promocionId;

    @NotNull(message = "El ID del paquete es obligatorio.")
    @Min(value = 1, message = "El ID del paquete debe ser un valor positivo.")
    private Long paqueteActividadId;
}