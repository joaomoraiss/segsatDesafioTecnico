package com.segsat.segsat.repository;

import com.segsat.segsat.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);

    boolean existsByEmail(String email);
}
