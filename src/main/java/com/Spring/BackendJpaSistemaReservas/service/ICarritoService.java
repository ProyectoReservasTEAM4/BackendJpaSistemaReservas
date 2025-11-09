package com.Spring.BackendJpaSistemaReservas.service;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Carrito;

import java.util.List;
import java.util.Optional;

public interface ICarritoService {

    Carrito crear(Carrito carrito,Long id);
    Optional<Carrito> findById(Long id);
    String eliminar(Long id);
    List<Carrito> findAll();

}