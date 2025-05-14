package com.example.tuwaiqfinalproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Sport name must not be empty")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String name;

    @Min(value = 1, message = "Default player count must be at least 1")
    @Column(columnDefinition = "int not null")
    private Integer default_player_count;

    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Field> fields;
}
