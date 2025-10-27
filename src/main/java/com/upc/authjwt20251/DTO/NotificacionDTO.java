package com.upc.authjwt20251.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacionDTO {
    private Long id;

    @NotBlank(message = "El mensaje de la notificación es obligatorio y no puede estar vaio.")
    @Size(max = 255, message = "El mensaje no puede exceder los 255 caracteres.")
    private String mensaje;

    @NotNull(message = "El ID de usuario es obligatorio.")
    @Min(value = 1, message = "El ID de usuario debe ser un valor positivo.")
    private Long usuarioId;

    private Boolean leida;
}