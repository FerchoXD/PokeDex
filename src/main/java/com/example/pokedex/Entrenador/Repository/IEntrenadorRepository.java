package com.example.pokedex.Entrenador.Repository;

import com.example.pokedex.Entrenador.Entity.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntrenadorRepository extends JpaRepository <Entrenador, Long> {
}
