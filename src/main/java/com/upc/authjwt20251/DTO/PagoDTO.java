package com.upc.authjwt20251.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoDTO {
    private Long id;

    @NotNull(message = "El monto del pago es obligatorio.")
    @Positive(message = "El monto debe ser un valor positivo.")
    private Double monto;

    @NotNull(message = "La fecha de pago es obligatoria.")
    private LocalDate fecha;

    @NotNull(message = "El ID del usuario es obligatorio.")
    @Min(value = 1, message = "El ID del usuario debe ser un valor positivo.")
    private Long usuarioId;

    @NotNull(message = "El ID de la reserva es obligatorio.")
    @Min(value = 1, message = "El ID de la reserva debe ser un valor positivo.")
    private Long reservaId;
}