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
public class UsuarioDTO {
    @NotBlank(message = "El nombre de usuario es obligatorio.")
    @Size(max = 50, message = "El nombre de usuario no puede exceder los 50 caracteres.")
    private String username;

    @NotBlank(message = "La contraseña es obligatoria.")
    @Size(max = 500, message = "La contraseña no puede exceder los 500 caracteres.")
    private String password;

    @NotNull(message = "El estado 'enabled' es obligatorio.")
    private Boolean enabled;

    @NotNull(message = "El ID del rol es obligatorio.")
    @Min(value = 1, message = "El ID del rol debe ser un valor positivo.")
    private Long rolId;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }

    public Long getRolId() { return rolId; }
    public void setRolId(Long rolId) { this.rolId = rolId; }
}