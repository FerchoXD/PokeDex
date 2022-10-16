package com.example.pokedex.repositories;

import com.example.pokedex.entities.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILeagueRepository extends JpaRepository<League,Long> {
}
