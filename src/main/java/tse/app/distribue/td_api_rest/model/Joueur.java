package tse.app.distribue.td_api_rest.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

/**
 * Entité Joueur
 */
@Entity
@Data
@NoArgsConstructor
public class Joueur {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    private String prenom;

    private LocalDate dateDeNaissance;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    // Si on supprime l'équipe, les joueurs vont aussi être supprimés
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Equipe equipe;
}

