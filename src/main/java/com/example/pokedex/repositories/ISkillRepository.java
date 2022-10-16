package com.example.pokedex.repositories;

import com.example.pokedex.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository <Skill, Long> {
}
