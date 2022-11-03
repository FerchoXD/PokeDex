package com.example.pokedex.repositories;

import com.example.pokedex.entities.pivots.TrainersForum;
import com.example.pokedex.entities.projections.TrainerProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITrainersForumRepository extends JpaRepository<TrainersForum,Long> {

    @Query(value ="SELECT forums.*, forums.topic AS forumsTopic, " +
            "forums.category AS forumsCategory FROM trainer_forum " +
            "INNER JOIN trainers ON trainer_forum.trainer_id = trainers.id " +
            "WHERE trainer_forum.forum_id = :forumId ", nativeQuery = true)
    List<TrainerProjections> listAllTrainersByForumId(Long forumId);
}
