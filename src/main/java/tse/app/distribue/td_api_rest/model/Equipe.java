package tse.app.distribue.td_api_rest.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Equipe {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //@OneToMany(mappedBy = "equipe")
    @OneToMany
    private List<Joueur> joueurs;
}
