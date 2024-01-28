package tse.app.distribue.td_api_rest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entité Equipe
 */

@Entity
@Data
@NoArgsConstructor
// Afin d'afficher seulement l'id de l'équipe dans la classe joueur lorsqu'on affiche les joueurs d'une équipe
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Equipe {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "equipe")
    private List<Joueur> joueurs;
}
