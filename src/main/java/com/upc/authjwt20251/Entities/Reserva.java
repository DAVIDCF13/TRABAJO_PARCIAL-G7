package com.upc.authjwt20251.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private int cantidadPersonas;

    @ManyToOne
    @JoinColumn(name = "alojamiento_id", nullable = false)
    private Alojamiento alojamiento;

    @ManyToOne
    @JoinColumn(name = "paquete_turistico_id", nullable = false)
    private PaqueteTuristico paqueteTuristico;

    @ManyToOne
    @JoinColumn(name = "transporte_id", nullable = true)
    private Transporte transporte;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public int getCantidadPersonas() { return cantidadPersonas; }
    public void setCantidadPersonas(int cantidadPersonas) { this.cantidadPersonas = cantidadPersonas; }

    public Alojamiento getAlojamiento() { return alojamiento; }
    public void setAlojamiento(Alojamiento alojamiento) { this.alojamiento = alojamiento; }

    public PaqueteTuristico getPaqueteTuristico() { return paqueteTuristico; }
    public void setPaqueteTuristico(PaqueteTuristico paqueteTuristico) { this.paqueteTuristico = paqueteTuristico; }

    public Transporte getTransporte() { return transporte; }
    public void setTransporte(Transporte transporte) { this.transporte = transporte; }
}