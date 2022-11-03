package com.example.pokedex.repositories;

import com.example.pokedex.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository <Comment, Long> {
}
