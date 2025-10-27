package com.upc.authjwt20251.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActividadDTO {
    private Long id;

    @NotBlank(message = "El nombre es obligatorio y no puede estar vacio.")
    @Size(max = 50, message = "El nombre de la actividad no puede exceder los 50 caracteres.")
    private String nombre;

    @NotBlank(message = "La descripción es obligatoria y no puede estar vacia.")
    @Size(max = 100, message = "La descripción de la actividad no puede exceder los 100 caracteres.")
    private String descripcion;

    @NotNull(message = "El precio es obligatorio.")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor que cero (0).")
    private Double precio;

    @NotNull(message = "Debe seleccionarse el ID del Paquete de Actividad.")
    @Min(value = 1, message = "El ID del paquete de actividad debe ser un valor positivo.")
    private Long paqueteActividadId;
}