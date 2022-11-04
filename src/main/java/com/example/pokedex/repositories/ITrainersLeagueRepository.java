package com.example.pokedex.repositories;

import com.example.pokedex.entities.pivots.TrainersLeague;
import com.example.pokedex.entities.projections.TrainerProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITrainersLeagueRepository extends JpaRepository<TrainersLeague,Long> {

    @Query(value ="SELECT trainers.*,trainers.id AS trainersId, " +
            "trainers.category AS trainersCategory,trainers.name AS trainersName " +
            ",trainers.profile_picture AS trainersProfilePicture FROM trainer_league " +
            "INNER JOIN trainers ON trainer_league.trainer_id = trainers.id " +
            "WHERE trainer_league.league_id = :leagueId", nativeQuery = true)
    List<TrainerProjections> listAllTrainersByLeagueId(Long leagueId);
}










