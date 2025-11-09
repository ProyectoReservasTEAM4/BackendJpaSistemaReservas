package com.Spring.BackendJpaSistemaReservas.persistence.repository;

import com.Spring.BackendJpaSistemaReservas.persistence.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
