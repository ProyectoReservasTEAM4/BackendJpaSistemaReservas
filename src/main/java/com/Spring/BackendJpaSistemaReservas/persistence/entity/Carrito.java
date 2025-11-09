package com.Spring.BackendJpaSistemaReservas.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Carrito")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties({"carrito", "reservas"})
    private Cliente cliente;


    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnoreProperties({"carrito", "reservas"})
    private List<Pelicula> peliculas;
}
