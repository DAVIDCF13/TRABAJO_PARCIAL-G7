package com.upc.authjwt20251.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpinionTuristaDTO {
    private Long id;

    @NotBlank(message = "El comentario es obligatorio y no puede estar vacio.")
    @Size(max = 500, message = "El comentario no puede exceder los 500 caracteres.")
    private String comentario;

    @NotNull(message = "La calificación es obligatoria.")
    @Min(value = 1, message = "La calificacion minima debe ser 1.")
    @Max(value = 5, message = "La calificacion maxima debe ser 5.")
    private Integer calificacion;

    @NotNull(message = "El ID del usuario es obligatorio.")
    @Min(value = 1, message = "El ID del usuario debe ser un valor positivo.")
    private Long usuarioId;

    @NotNull(message = "El ID del destino es obligatorio.")
    @Min(value = 1, message = "El ID del destino debe ser un valor positivo.")
    private Long destinoId;
}