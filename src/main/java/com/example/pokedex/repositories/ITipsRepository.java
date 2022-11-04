package com.example.pokedex.repositories;

import com.example.pokedex.entities.Tips;
import com.example.pokedex.entities.projections.TipsProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipsRepository extends JpaRepository<Tips,Long> {
    @Query(value = "SELECT tips.id,tips.description,tips.image FROM tips " +
            "INNER JOIN trainers ON tips.trainer_id = trainers.id " +
            "WHERE trainers.id = :trainersId",nativeQuery = true)
    List<TipsProjections> listAllTrainersByPokemonId(Long trainersId);
}
