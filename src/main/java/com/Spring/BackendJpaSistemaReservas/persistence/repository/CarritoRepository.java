package com.Spring.BackendJpaSistemaReservas.persistence.repository;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito,Long> {
}