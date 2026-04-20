package com.example.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.NEOAPP.modelos.Gasto;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Integer> {
}
