package com.upc.authjwt20251.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "paquete_actividad")
public class PaqueteActividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @OneToMany(mappedBy = "paqueteActividad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Actividad> actividades;

    @ManyToOne
    @JoinColumn(name = "paquete_turistico_id", nullable = false)
    private PaqueteTuristico paqueteTuristico;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public List<Actividad> getActividades() { return actividades; }
    public void setActividades(List<Actividad> actividades) { this.actividades = actividades; }

    public PaqueteTuristico getPaqueteTuristico() { return paqueteTuristico; }
    public void setPaqueteTuristico(PaqueteTuristico paqueteTuristico) { this.paqueteTuristico = paqueteTuristico; }
}