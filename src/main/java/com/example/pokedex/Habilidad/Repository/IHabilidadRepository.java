package com.example.pokedex.Habilidad.Repository;

import com.example.pokedex.Habilidad.Entity.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadRepository extends JpaRepository <Habilidad, Long> {
}
