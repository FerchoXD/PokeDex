package com.example.pokedex.Pokebola.Repository;

import com.example.pokedex.Pokebola.Entity.Pokebola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPokebolaRepository extends JpaRepository<Pokebola,Long> {
}
