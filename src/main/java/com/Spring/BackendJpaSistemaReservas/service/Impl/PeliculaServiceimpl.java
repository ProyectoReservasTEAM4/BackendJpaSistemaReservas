package com.Spring.BackendJpaSistemaReservas.service.Impl;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Carrito;
import com.Spring.BackendJpaSistemaReservas.persistence.entity.Pelicula;
import com.Spring.BackendJpaSistemaReservas.persistence.repository.CarritoRepository;
import com.Spring.BackendJpaSistemaReservas.persistence.repository.PeliculaRepository;
import com.Spring.BackendJpaSistemaReservas.persistence.repository.ReservasRepository;
import com.Spring.BackendJpaSistemaReservas.service.IPeliculaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PeliculaServiceimpl implements IPeliculaService {

    private final PeliculaRepository peliculaRepository;
    private final CarritoRepository carritoRepository;
    private final ReservasRepository reservasRepository;

    public PeliculaServiceimpl(PeliculaRepository peliculaRepository, CarritoRepository carritoRepository, ReservasRepository reservasRepository) {
        this.peliculaRepository = peliculaRepository;
        this.carritoRepository = carritoRepository;
        this.reservasRepository = reservasRepository;
    }

    @Override
    public Pelicula crear(Pelicula pelicula, Long carritoId) {
        Carrito carrito = carritoRepository.findById(carritoId)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado con id: " + carritoId));
        pelicula.setCarrito(carrito);
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Optional<Pelicula> findById(Long id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula actualizar(Pelicula pelicula, Long id) {
        Pelicula peliculaExistente = peliculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelicula no encontrada con id: " + id));

        peliculaExistente.setTitulo(pelicula.getTitulo());
        peliculaExistente.setGenero(pelicula.getGenero());
        peliculaExistente.setDescripcion(pelicula.getDescripcion());
        peliculaExistente.setDuracion(pelicula.getDuracion());
        peliculaExistente.setStock(pelicula.getStock());
        peliculaExistente.setPrecio(pelicula.getPrecio());
        peliculaExistente.setImagen(pelicula.getImagen());

        return peliculaRepository.save(peliculaExistente);
    }

    @Override
    public String eliminar(Long id) {
        Optional<Pelicula> eliminar = peliculaRepository.findById(id);
        if (eliminar.isPresent()) {
            peliculaRepository.delete(eliminar.get());
            return "Pelicula eliminada con éxito";
        }
        return "No se encontró la película con id: " + id;
    }
}