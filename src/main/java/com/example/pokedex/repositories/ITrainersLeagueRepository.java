package com.example.pokedex.repositories;

import com.example.pokedex.entities.pivots.TrainersLeague;
import com.example.pokedex.entities.projections.LeagueProjections;
import com.example.pokedex.entities.projections.TrainerLeagueProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITrainersLeagueRepository extends JpaRepository<TrainersLeague,Long> {

    @Query(value ="SELECT trainers.*,trainers.id AS trainersId, " +
            "trainers.category AS trainersCategory ,trainers.name AS trainersName" +
            ",trainers.image AS trainersImage, leagues.id AS leaguesId, " +
            "leagues.name AS leaguesName FROM trainer_league " +
            "INNER JOIN trainers ON trainer_league.trainer_id = trainers.id " +
            "INNER JOIN leagues ON trainer_league.league_id = leagues.id " +
            "WHERE trainer_league.league_id = :leagueId", nativeQuery = true)
    List<TrainerLeagueProjections> listAllTrainersByLeagueId(Long leagueId);



    @Query(value = "SELECT leagues.*,leagues.id AS leagueId, " +
            "leagues.name AS leagueName,leagues.image AS leagueImage, " +
            "leagues.region AS leaguesReqion, trainers.id AS trainersId, " +
            "trainers.name AS trainersName FROM trainer_league " +
            "INNER JOIN leagues ON trainer_league.league_id = leagues.id " +
            "INNER JOIN trainers ON trainer_league.trainer_id = trainers.id " +
            "WHERE trainer_league.trainer_id = :trainerId ",nativeQuery = true)
    List<LeagueProjections> listAllLeaguesByTrainersId(Long trainerId);
}










