package com.upc.authjwt20251.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "promocion")
public class Promocion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double descuento;

    @ManyToOne
    @JoinColumn(name = "paquete_turistico_id", nullable = true)
    private PaqueteTuristico paqueteTuristico;

    @ManyToOne
    @JoinColumn(name = "producto_local_id", nullable = true)
    private ProductoLocal productoLocal;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getDescuento() { return descuento; }
    public void setDescuento(Double descuento) { this.descuento = descuento; }

    public PaqueteTuristico getPaqueteTuristico() { return paqueteTuristico; }
    public void setPaqueteTuristico(PaqueteTuristico paqueteTuristico) { this.paqueteTuristico = paqueteTuristico; }

    public ProductoLocal getProductoLocal() { return productoLocal; }
    public void setProductoLocal(ProductoLocal productoLocal) { this.productoLocal = productoLocal; }
}