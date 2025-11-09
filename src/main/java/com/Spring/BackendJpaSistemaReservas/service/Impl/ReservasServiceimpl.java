package com.Spring.BackendJpaSistemaReservas.service.Impl;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Cliente;
import com.Spring.BackendJpaSistemaReservas.persistence.entity.Pelicula;
import com.Spring.BackendJpaSistemaReservas.persistence.entity.Reservas;
import com.Spring.BackendJpaSistemaReservas.persistence.repository.ClienteRepository;
import com.Spring.BackendJpaSistemaReservas.persistence.repository.PeliculaRepository;
import com.Spring.BackendJpaSistemaReservas.persistence.repository.ReservasRepository;
import com.Spring.BackendJpaSistemaReservas.service.IReservasService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservasServiceimpl implements IReservasService {

    private final ReservasRepository reservasRepository;
    private final ClienteRepository clienteRepository;
    private final PeliculaRepository peliculaRepository;

    public ReservasServiceimpl(
            ReservasRepository reservasRepository,
            ClienteRepository clienteRepository,
            PeliculaRepository peliculaRepository
    ) {
        this.reservasRepository = reservasRepository;
        this.clienteRepository = clienteRepository;
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public List<Reservas> findAll() {
        return reservasRepository.findAll();
    }

    @Override
    public Optional<Reservas> findById(Long id) {
        return reservasRepository.findById(id);
    }


    @Override
    public Reservas crear(Reservas reservas, Long clienteId, Long peliculaId) {

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente con id " + clienteId + " no encontrado"));

        Pelicula pelicula = peliculaRepository.findById(peliculaId)
                .orElseThrow(() -> new RuntimeException("Película con id " + peliculaId + " no encontrada"));

        // Verificamos stock disponible
        if (pelicula.getStock() <= 0) {
            throw new RuntimeException("No hay stock disponible para la película " + pelicula.getTitulo());
        }

        // Resta una unidad al stock
        pelicula.setStock(pelicula.getStock() - 1);
        peliculaRepository.save(pelicula);


        reservas.setCliente(cliente);
        reservas.setPelicula(pelicula);
        reservas.setFechaReserva(LocalDate.now());
        reservas.setEstado(reservas.getEstado());

        return reservasRepository.save(reservas);
    }

    @Override
    public Reservas actualizar(Reservas reservas, Long id) {
        Reservas reservasActual = reservasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con id " + id));

        reservasActual.setEstado(reservas.getEstado());
        reservasActual.setMetodoPago(reservas.getMetodoPago());
        reservasActual.setNombre(reservas.getNombre());

        if (reservas.getCliente() != null && reservas.getCliente().getId() != null) {
            Cliente cliente = clienteRepository.findById(reservas.getCliente().getId())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
            reservasActual.setCliente(cliente);
        }

        if (reservas.getPelicula() != null && reservas.getPelicula().getId() != null) {
            Pelicula pelicula = peliculaRepository.findById(reservas.getPelicula().getId())
                    .orElseThrow(() -> new RuntimeException("Película no encontrada"));
            reservasActual.setPelicula(pelicula);
        }

        return reservasRepository.save(reservasActual);
    }

    @Override
    public String eliminar(Long id) {
        Optional<Reservas> eliminar = reservasRepository.findById(id);
        if (eliminar.isPresent()) {
            reservasRepository.delete(eliminar.get());
            return "Reserva eliminada correctamente con id " + id;
        } else {
            return "No se encontró la reserva con id " + id;
        }
    }
}