package com.upc.authjwt20251.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detalle_carrito")
public class DetalleCarrito implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carrito_id", nullable = false)
    private CarritoCompra carritoCompra;

    @ManyToOne
    @JoinColumn(name = "producto_local_id", nullable = false)
    private ProductoLocal productoLocal;

    @Column(nullable = false)
    private Integer cantidad;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public CarritoCompra getCarritoCompra() { return carritoCompra; }
    public void setCarritoCompra(CarritoCompra carritoCompra) { this.carritoCompra = carritoCompra; }

    public ProductoLocal getProductoLocal() { return productoLocal; }
    public void setProductoLocal(ProductoLocal productoLocal) { this.productoLocal = productoLocal; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}