package com.example.pokedex.entities;


import com.example.pokedex.entities.pivots.TrainersForum;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
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

    private Date date;

    private Time hour;

    @OneToMany(mappedBy = "forum")
    private List<TrainersForum> trainersForum;
}
