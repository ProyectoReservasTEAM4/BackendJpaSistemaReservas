package com.Spring.BackendJpaSistemaReservas.service.Impl;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Cliente;
import com.Spring.BackendJpaSistemaReservas.persistence.repository.ClienteRepository;
import com.Spring.BackendJpaSistemaReservas.service.IClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceimpl implements IClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteServiceimpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }


    @Override
    public Cliente crear(Cliente cliente) {
        if (cliente.getReservas() != null) {
            cliente.getReservas().forEach(reserva -> reserva.setCliente(cliente));
        }
        return clienteRepository.save(cliente);
    }


    @Override
    public String eliminar(Long id) {
        Optional<Cliente> obtener = findById(id);

        if (obtener.isPresent()){
            Cliente cliente = obtener.get();
            clienteRepository.delete(cliente);
            return "Usuario con "+ id + "Elimando";
        }else {
            return "Error al elimnar el usuario";

        }

    }

    @Override
    public Cliente Actualizar(Cliente cliente, Long id) {
        Optional<Cliente> actualizar = findById(id);
        if (actualizar.isPresent()){
            Cliente obtener = actualizar.get();
            obtener.setEmail(cliente.getEmail());
            obtener.setName(cliente.getName());
            obtener.setPassword(cliente.getPassword());
            obtener.setPicture(cliente.getPicture());


            if (obtener.getReservas() != null){
                obtener.getReservas().clear();
                obtener.getReservas().forEach(reservas -> reservas.setCliente(obtener));
                obtener.getReservas().addAll(cliente.getReservas());
            }
            return clienteRepository.save(obtener);
        }
        return cliente;
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }
}

