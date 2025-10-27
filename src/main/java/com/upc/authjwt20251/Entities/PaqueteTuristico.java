package com.upc.authjwt20251.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "paquete_turistico")
public class PaqueteTuristico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @OneToMany(mappedBy = "paqueteTuristico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "paqueteTuristico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Promocion> promociones;

    @OneToMany(mappedBy = "paqueteTuristico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PaqueteActividad> paquetesActividad;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public List<Reserva> getReservas() { return reservas; }
    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }

    public List<Promocion> getPromociones() { return promociones; }
    public void setPromociones(List<Promocion> promociones) { this.promociones = promociones; }

    public List<PaqueteActividad> getPaquetesActividad() { return paquetesActividad; }
    public void setPaquetesActividad(List<PaqueteActividad> paquetesActividad) { this.paquetesActividad = paquetesActividad; }
}