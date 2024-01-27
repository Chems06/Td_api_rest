package tse.app.distribue.td_api_rest.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Equipe equipe;
}

