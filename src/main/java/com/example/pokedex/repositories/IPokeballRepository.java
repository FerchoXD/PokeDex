package com.example.pokedex.repositories;

import com.example.pokedex.entities.Pokeball;
import com.example.pokedex.entities.projections.PokeballProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPokeballRepository extends JpaRepository<Pokeball,Long> {

    @Query(value = "SELECT pokeballs.id, pokeballs.name,pokeballs.image " +
            "FROM pokeballs " +
            "INNER JOIN pokemons ON pokeballs.id = pokemons.id " +
            "WHERE pokemons.id = :pokemonId ",nativeQuery = true)
    List<PokeballProjections> listAllTrainersByPokemonId(Long pokemonId);
}
