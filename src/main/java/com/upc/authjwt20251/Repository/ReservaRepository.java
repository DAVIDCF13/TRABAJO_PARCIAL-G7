package com.upc.authjwt20251.Repository;

import com.upc.authjwt20251.Entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query("SELECT r FROM Reserva r WHERE r.alojamiento.id = :alojamientoId")
    List<Reserva> findByAlojamiento(@Param("alojamientoId") Long alojamientoId);

    @Query("SELECT r.paqueteTuristico.nombre AS paquete, COUNT(r.id) AS totalReservas " +
            "FROM Reserva r " +
            "GROUP BY r.paqueteTuristico.nombre " +
            "HAVING COUNT(r.id) > :minimo")
    List<Object[]> findPaquetesConMasDeNReservas(@Param("minimo") Long minimo);

    @Query("SELECT r FROM Reserva r " +
            "WHERE FUNCTION('YEAR', r.fecha) BETWEEN :anioInicio AND :anioFin " +
            "ORDER BY r.fecha")
    List<Reserva> findReservasEntreAnios(@Param("anioInicio") int anioInicio,
                                         @Param("anioFin") int anioFin);

    @Query("SELECT r.transporte.empresa AS transporte, COUNT(r.id) AS totalReservas " +
            "FROM Reserva r " +
            "GROUP BY r.transporte.empresa")
    List<Object[]> countReservasPorTransporte();

}