package com.upc.authjwt20251.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "actividad")
public class Actividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "paquete_actividad_id", nullable = false)
    private PaqueteActividad paqueteActividad;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public PaqueteActividad getPaqueteActividad() { return paqueteActividad; }
    public void setPaqueteActividad(PaqueteActividad paqueteActividad) { this.paqueteActividad = paqueteActividad; }
}