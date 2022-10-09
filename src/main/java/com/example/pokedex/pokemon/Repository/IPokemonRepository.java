package com.example.pokedex.pokemon.Repository;

import com.example.pokedex.pokemon.Entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPokemonRepository extends JpaRepository <Pokemon, Long> {
}
