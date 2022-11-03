package com.example.pokedex.repositories;

import com.example.pokedex.entities.Tips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipsRepository extends JpaRepository<Tips,Long> {
}
