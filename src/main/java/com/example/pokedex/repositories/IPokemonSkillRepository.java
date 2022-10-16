package com.example.pokedex.repositories;

import com.example.pokedex.entities.Projections.SkillProjections;
import com.example.pokedex.pivots.PokemonsSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPokemonSkillRepository extends JpaRepository<PokemonsSkill,Long> {

    @Query(value ="select skill.* from pokemons_skill " +
            "inner join skill on pokemons_skill.skill_id = skill.id " +
            "inner join pokemon on pokemons_skill.pokemon_id = pokemon.id " +
            "where pokemons_skill.pokemon_id = :pokemonId ", nativeQuery = true)
    List<SkillProjections> listAllSkillsByPokemonId(Long pokemonId);
}
