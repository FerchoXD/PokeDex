package com.example.pokedex.Liga.Repository;

import com.example.pokedex.Liga.Entity.Liga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILigaRepository extends JpaRepository<Liga,Long> {
}
