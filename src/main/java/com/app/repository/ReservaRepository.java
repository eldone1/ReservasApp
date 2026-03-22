package com.app.repository;

import com.app.entity.EstadoReserva;
import com.app.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    // El cliente ve sus propias reservas
    List<Reserva> findByClienteId(Long clienteId);

    // El admin filtra reservas por fecha (ver el día completo)
    List<Reserva> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);

    // El admin filtra por estado (ver todas las PENDIENTES, por ejemplo)
    List<Reserva> findByEstado(EstadoReserva estado);

    // Regla de negocio clave: verificar si una mesa ya está reservada
    // en ese rango de fecha/hora antes de confirmar una nueva reserva
    boolean existsByMesaIdAndEstadoAndFechaHoraBetween(
            Long mesaId,
            EstadoReserva estado,
            LocalDateTime inicio,
            LocalDateTime fin
    );

    // Vista del admin: reservas de un día ordenadas por hora
    List<Reserva> findByFechaHoraBetweenOrderByFechaHoraAsc(
            LocalDateTime inicio,
            LocalDateTime fin
    );

}
