package com.Spring.BackendJpaSistemaReservas.controller;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Cliente;
import com.Spring.BackendJpaSistemaReservas.service.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {
    private IClienteService iClienteService;

    public ClienteController(IClienteService iClienteService) {
        this.iClienteService = iClienteService;
    }

    @GetMapping("/obtener")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(iClienteService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/Crear")
    public ResponseEntity<?> crear(@RequestBody Cliente cliente){
        return new ResponseEntity<>(iClienteService.crear(cliente),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(iClienteService.findById(id),HttpStatus.OK);
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Cliente cliente,@PathVariable Long id){
        return new ResponseEntity<>(iClienteService.Actualizar(cliente,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        return new ResponseEntity<>(iClienteService.eliminar(id),HttpStatus.OK);
    }





}
