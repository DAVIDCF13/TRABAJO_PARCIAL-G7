package com.upc.authjwt20251.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromocionDTO {
    private Long id;

    @NotBlank(message = "El nombre de la promoción es obligatorio.")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres.")
    private String nombre;

    @NotNull(message = "El descuento es obligatorio.")
    @DecimalMin(value = "0.01", message = "El descuento debe ser mayor que 0.")
    @DecimalMax(value = "1.0", message = "El descuento no puede ser mayor que 1 (100%).")
    private Double descuento;

    @NotNull(message = "El ID del paquete turistico es obligatorio.")
    @Min(value = 1, message = "El ID del paquete turistico debe ser un valor positivo.")
    private Long paqueteTuristicoId;

    @NotNull(message = "El ID del producto local es obligatorio.")
    @Min(value = 1, message = "El ID del producto local debe ser un valor positivo.")
    private Long productoLocalId;
}