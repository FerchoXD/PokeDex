package com.example.pokedex.repositories;

import com.example.pokedex.entities.Pokebola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPokebolaRepository extends JpaRepository<Pokebola,Long> {
}
