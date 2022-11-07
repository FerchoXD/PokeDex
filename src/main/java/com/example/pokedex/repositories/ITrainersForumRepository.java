package com.example.pokedex.repositories;

import com.example.pokedex.entities.pivots.TrainersForum;
import com.example.pokedex.entities.projections.TrainerForumProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITrainersForumRepository extends JpaRepository<TrainersForum,Long> {

    @Query(value ="SELECT trainers.*,trainers.id AS trainersId, " +
            "trainers.name AS trainerName, forums.id AS forumsId," +
            "forums.topic AS forumsTopic FROM trainer_forum " +
            "INNER JOIN trainers ON trainer_forum.trainer_id = trainers.id " +
            "INNER JOIN forums ON trainer_forum.forum_id = forums.id " +
            "WHERE trainer_forum.forum_id = :forumId ", nativeQuery = true)
    List<TrainerForumProjections> listAllTrainersByForumId(Long forumId);
}
