package com.example.pokedex.pokemones.Repository;

import com.example.pokedex.pokemones.Entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPokemonRepository extends JpaRepository <Pokemon, Long> {
}
