package com.upc.authjwt20251.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "opinion_local")
public class OpinionLocal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comentario;

    @Column(nullable = false)
    private Integer calificacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "producto_local_id", nullable = false)
    private ProductoLocal productoLocal;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public Integer getCalificacion() { return calificacion; }
    public void setCalificacion(Integer calificacion) { this.calificacion = calificacion; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public ProductoLocal getProductoLocal() { return productoLocal; }
    public void setProductoLocal(ProductoLocal productoLocal) { this.productoLocal = productoLocal; }
}