package com.app.repository;

import com.app.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MesaRepository extends JpaRepository<Mesa, Long> {

    // Mostrar solo mesas libres para el cliente
    List<Mesa> findByDisponibleTrue();

    // Buscar mesas que tengan capacidad suficiente para el grupo
    List<Mesa> findByCapacidadGreaterThanEqualAndDisponibleTrue(Integer cantidadPersonas);
}
