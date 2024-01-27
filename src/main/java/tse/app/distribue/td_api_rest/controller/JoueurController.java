package tse.app.distribue.td_api_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tse.app.distribue.td_api_rest.Exception.ResourceNotFoundException;
import tse.app.distribue.td_api_rest.model.Joueur;
import tse.app.distribue.td_api_rest.service.JoueurService;

import java.util.List;

/**
 * Contrôleur REST pour gérer l'entité Joueur
 */

@RestController
public class JoueurController {

    @Autowired
    private JoueurService joueurService; // Injection de dépendance du service Joueur

    // Endpoint pour récupérer tous les joueurs
    @GetMapping("/joueurs")
    public List<Joueur> allJoueurs() {
        return this.joueurService.findAllJoueurs();
    }

    // Endpoint pour récupérer un seul joueur par son ID
    @GetMapping("/joueurs/{id}")
    public Joueur oneJoueur(@PathVariable Long id) throws ResourceNotFoundException {
        Joueur result = this.joueurService.findJoueur(id);
        if (result != null) {
            return result;
        } else {
            throw new ResourceNotFoundException(); // Lance une exception si le joueur n'est pas trouvé
        }
    }

    // Endpoint pour créer un nouveau joueur
    @PostMapping("/joueurs")
    public Joueur createJoueur(@RequestBody Joueur joueur) {
        return this.joueurService.createJoueur(joueur);
    }

    // Endpoint pour supprimer un joueur par son ID
    @DeleteMapping("/joueurs/{id}")
    public void deleteJoueur(@PathVariable Long id) {
        this.joueurService.deleteJoueur(id);
    }

    // Endpoint pour mettre à jour un joueur existant par son ID
    @PutMapping("/joueurs/{id}")
    Joueur replaceJoueur(@RequestBody Joueur joueur, @PathVariable Long id) {
        Joueur foundJoueur = this.joueurService.findJoueur(id);
        if (foundJoueur != null) {
            // Met à jour les attributs du joueur avec ceux du nouveau joueur
            foundJoueur.setNom(joueur.getNom());
            foundJoueur.setPrenom(joueur.getPrenom());
            foundJoueur.setDateDeNaissance(joueur.getDateDeNaissance());
            foundJoueur.setEquipe(joueur.getEquipe());

            // Enregistre les modifications du joueur
            foundJoueur = this.joueurService.saveJoueur(foundJoueur);
        }
        return foundJoueur;
    }
}
