package com.example.pokedex.repositories;

import com.example.pokedex.entities.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntrenadorRepository extends JpaRepository <Entrenador, Long> {
}
