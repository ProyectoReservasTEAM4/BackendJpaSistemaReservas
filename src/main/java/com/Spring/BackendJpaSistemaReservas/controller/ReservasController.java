package com.Spring.BackendJpaSistemaReservas.controller;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Reservas;
import com.Spring.BackendJpaSistemaReservas.service.IReservasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservasController {


    private IReservasService iReservasService;

    public ReservasController(IReservasService iReservasService) {
        this.iReservasService = iReservasService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(iReservasService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(iReservasService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/crear/{id}/{peliculaId}")
    public ResponseEntity<?> crear(@RequestBody Reservas reservas, @PathVariable Long id,@PathVariable Long peliculaId){
        return new ResponseEntity<>(iReservasService.crear(reservas,id,peliculaId),HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Reservas reservas, @PathVariable Long id){
        return new ResponseEntity<>(iReservasService.actualizar(reservas,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> elimnar(@PathVariable Long id){
        return new ResponseEntity<>(iReservasService.eliminar(id),HttpStatus.OK);
    }



}
