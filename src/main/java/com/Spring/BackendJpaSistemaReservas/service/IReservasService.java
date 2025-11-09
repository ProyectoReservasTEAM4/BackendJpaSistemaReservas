package com.Spring.BackendJpaSistemaReservas.service;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Reservas;

import java.util.List;
import java.util.Optional;

public interface IReservasService {
    String eliminar(Long id);
    List<Reservas> findAll();
    Reservas crear(Reservas reservas, Long clienteId, Long peliculaId);
    Reservas actualizar(Reservas reservas, Long id);
    Optional<Reservas> findById(Long id);
}