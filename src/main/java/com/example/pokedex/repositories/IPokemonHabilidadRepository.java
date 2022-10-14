package com.example.pokedex.repositories;

import com.example.pokedex.entities.Projections.HabilidadProjections;
import com.example.pokedex.pivots.PokemonsHabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPokemonHabilidadRepository extends JpaRepository<PokemonsHabilidad,Long> {

    @Query(value ="select habilidad.* from pokemons_habilidades " +
            "inner join habilidad on pokemons_habilidades.habilidad_id = habilidad.id " +
            "inner join pokemon on pokemons_habilidades.pokemon_id = pokemon.id " +
            "where pokemons_habilidades.pokemon_id = :pokemonId ", nativeQuery = true)
    List<HabilidadProjections> listAllHabilidadesByPokemonId(Long pokemonId);
}
