package com.upc.authjwt20251.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "carrito_compra")
public class CarritoCompra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "carritoCompra", cascade = CascadeType.ALL)
    private List<DetalleCarrito> detalles;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<DetalleCarrito> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleCarrito> detalles) { this.detalles = detalles; }
}