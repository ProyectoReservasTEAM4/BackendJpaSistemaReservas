package com.Spring.BackendJpaSistemaReservas.controller;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Pelicula;
import com.Spring.BackendJpaSistemaReservas.service.IPeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pelicula")
public class PeliculaController {

    private final IPeliculaService iPeliculaService;

    public PeliculaController(IPeliculaService iPeliculaService) {
        this.iPeliculaService = iPeliculaService;
    }

    @GetMapping("/todos")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(iPeliculaService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/crear/{id}")
    public ResponseEntity<?> crear(@RequestBody Pelicula pelicula, @PathVariable Long id){
        return new ResponseEntity<>(iPeliculaService.crear(pelicula,id),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(iPeliculaService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/cambio/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Pelicula pelicula, @PathVariable Long id){
        return  new ResponseEntity<>(iPeliculaService.actualizar(pelicula,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        return new ResponseEntity<>(iPeliculaService.eliminar(id),HttpStatus.OK);
    }





}
