package com.example.pokedex.repositories;

import com.example.pokedex.entities.Liga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILigaRepository extends JpaRepository<Liga,Long> {
}
