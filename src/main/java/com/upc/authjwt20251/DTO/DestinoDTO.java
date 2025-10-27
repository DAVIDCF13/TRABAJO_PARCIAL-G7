package com.upc.authjwt20251.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinoDTO {
    private Long id;

    @NotBlank(message = "El nombre del destino es obligatorio y no puede estar vacío.")
    @Size(max = 50, message = "El nombre no puede exceder los 50 caracteres.")
    private String nombre;

    @NotBlank(message = "El país es obligatorio y no puede estar vacío.")
    @Size(max = 20, message = "El país no puede exceder los 20 caracteres.")
    private String pais;

    @NotBlank(message = "La descripción es obligatoria y no puede estar vacía.")
    @Size(max = 100, message = "La descripción no puede exceder los 100 caracteres.")
    private String descripcion;
}