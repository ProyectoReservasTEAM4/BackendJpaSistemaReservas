package com.Spring.BackendJpaSistemaReservas.service.Impl;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Carrito;
import com.Spring.BackendJpaSistemaReservas.persistence.entity.Cliente;
import com.Spring.BackendJpaSistemaReservas.persistence.repository.CarritoRepository;
import com.Spring.BackendJpaSistemaReservas.persistence.repository.ClienteRepository;
import com.Spring.BackendJpaSistemaReservas.service.ICarritoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoServiceimpl implements ICarritoService {

    private final ClienteRepository clienteRepository;
    private final CarritoRepository carritoRepository;

    public CarritoServiceimpl(ClienteRepository clienteRepository, CarritoRepository carritoRepository) {
        this.clienteRepository = clienteRepository;
        this.carritoRepository = carritoRepository;
    }

    @Override
    public Carrito crear(Carrito carrito, Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente con id " + idCliente + " no encontrado"));


        if (cliente.getCarrito() != null) {
            throw new RuntimeException("El cliente ya tiene un carrito asignado");
        }

        carrito.setCliente(cliente);
        return carritoRepository.save(carrito);
    }

    @Override
    public Optional<Carrito> findById(Long id) {
        return carritoRepository.findById(id);
    }

    @Override
    public String eliminar(Long id) {
        Optional<Carrito> eliminar = carritoRepository.findById(id);
        if (eliminar.isPresent()) {
            carritoRepository.delete(eliminar.get());
            return "Carrito eliminado correctamente";
        }
        return "No se encontró el carrito con id " + id;
    }

    @Override
    public List<Carrito> findAll() {
        return carritoRepository.findAll();
    }
}