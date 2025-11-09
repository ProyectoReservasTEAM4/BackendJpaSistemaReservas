package com.Spring.BackendJpaSistemaReservas.controller;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Carrito;
import com.Spring.BackendJpaSistemaReservas.service.ICarritoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    private final ICarritoService iCarritoService;

    public CarritoController(ICarritoService iCarritoService) {
        this.iCarritoService = iCarritoService;
    }

    @PostMapping("/crear/{id}")
    public ResponseEntity<?> crear(@RequestBody Carrito carrito, @PathVariable Long id){
        return new ResponseEntity<>(iCarritoService.crear(carrito,id), HttpStatus.CREATED);
    }

    @GetMapping("/todos")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(iCarritoService.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        return new ResponseEntity<>(iCarritoService.eliminar(id),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(iCarritoService.findById(id),HttpStatus.OK);
    }

}