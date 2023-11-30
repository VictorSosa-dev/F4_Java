package org.java.backend.bedu.s5pokemon.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@ToString
@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    @Range(min = 1, max = 907)
    private int number;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Type type;


}
