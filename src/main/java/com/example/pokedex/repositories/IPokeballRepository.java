package com.example.pokedex.repositories;

import com.example.pokedex.entities.Pokeball;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPokeballRepository extends JpaRepository<Pokeball,Long> {
}
