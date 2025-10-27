package com.upc.authjwt20251.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "notificacion")
public class Notificacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private Boolean leida;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Boolean getLeida() { return leida; }
    public void setLeida(Boolean leida) { this.leida = leida; }
}