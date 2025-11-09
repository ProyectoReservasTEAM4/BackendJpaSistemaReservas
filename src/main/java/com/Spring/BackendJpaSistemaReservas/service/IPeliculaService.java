package com.Spring.BackendJpaSistemaReservas.service;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Pelicula;

import java.util.List;
import java.util.Optional;

public interface IPeliculaService {
    Pelicula crear(Pelicula pelicula, Long id);
    Optional<Pelicula> findById(Long id);
    List<Pelicula> findAll();
    Pelicula actualizar(Pelicula pelicula,Long id);
    String eliminar (Long id);

}
