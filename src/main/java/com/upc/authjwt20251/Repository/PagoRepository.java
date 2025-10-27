package com.upc.authjwt20251.Repository;

import com.upc.authjwt20251.Entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    @Query("SELECT pa FROM Pago pa " +
            "WHERE FUNCTION('YEAR', pa.fecha) BETWEEN :anioInicio AND :anioFin " +
            "ORDER BY pa.fecha")
    List<Pago> findPagosEntreAnios(@Param("anioInicio") int anioInicio,
                                   @Param("anioFin") int anioFin);
}