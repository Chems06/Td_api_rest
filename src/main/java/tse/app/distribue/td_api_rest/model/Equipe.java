package tse.app.distribue.td_api_rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    //@JsonIgnore
    @OneToMany(mappedBy = "equipe")
    private List<Joueur> joueurs;
}
