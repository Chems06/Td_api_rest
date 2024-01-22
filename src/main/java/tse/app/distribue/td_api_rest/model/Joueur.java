package tse.app.distribue.td_api_rest.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Joueur {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
}

