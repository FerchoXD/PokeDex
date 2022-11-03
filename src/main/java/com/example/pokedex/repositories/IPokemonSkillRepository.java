package com.example.pokedex.repositories;

import com.example.pokedex.entities.projections.PokemonProjections;
import com.example.pokedex.entities.projections.SkillProjections;
import com.example.pokedex.entities.pivots.PokemonsSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPokemonSkillRepository extends JpaRepository<PokemonsSkill,Long> {

    @Query(value ="SELECT skills.*, pokemons.name AS pokemonName FROM pokemon_skill " +
            "INNER JOIN skills ON pokemon_skill.skill_id = skills.id " +
            "WHERE pokemon_skill.pokemon_id = :pokemonId ", nativeQuery = true)
    List<SkillProjections> listAllSkillsByPokemonId(Long pokemonId);

    @Query(value="SELECT pokemons.* FROM pokemon_skill " +
            "inner join pokemons on pokemon_skill.pokemon_id = pokemons.id " +
            "where pokemon_skill.skill_id = :skillId ", nativeQuery = true)
    List<PokemonProjections> listAllPokemonBySkillsId(Long skillId);

}
