package com.Spring.BackendJpaSistemaReservas.persistence.repository;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {
}
