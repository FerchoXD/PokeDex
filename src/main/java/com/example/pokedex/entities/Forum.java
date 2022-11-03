package com.example.pokedex.entities;


import com.example.pokedex.entities.pivots.TrainersForum;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "forums")
@Getter
@Setter
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;

    private String date;

    private String hour;

    @OneToMany(mappedBy = "forum")
    private List<TrainersForum> trainersForum;
}
