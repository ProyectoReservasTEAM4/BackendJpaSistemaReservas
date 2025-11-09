package com.Spring.BackendJpaSistemaReservas.service;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    List<Cliente> findAll();
    Cliente crear(Cliente cliente);
    String eliminar(Long id);
    Cliente Actualizar(Cliente cliente,Long id);
    Optional<Cliente> findById(Long id);


}
