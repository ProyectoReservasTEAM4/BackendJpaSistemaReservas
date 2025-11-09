package com.Spring.BackendJpaSistemaReservas.persistence.repository;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas,Long> {
}