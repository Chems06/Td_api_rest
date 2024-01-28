package tse.app.distribue.td_api_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tse.app.distribue.td_api_rest.Exception.ResourceNotFoundException;
import tse.app.distribue.td_api_rest.model.Equipe;
import tse.app.distribue.td_api_rest.service.EquipeService;

import java.util.List;

/**
 * Contrôleur REST pour gérer l'entité Equipe
 */

@RestController
public class EquipeController {

    @Autowired
    private EquipeService equipeService; // Injection de dépendance du service Equipe

    // Endpoint pour récupérer toutes les équipes
    @GetMapping("/equipes")
    public List<Equipe> allEquipes() {
        return this.equipeService.findAllEquipes();
    }

    // Endpoint pour récupérer une seule équipe par son ID
    @GetMapping("/equipes/{id}")
    public Equipe oneEquipe(@PathVariable Long id) throws ResourceNotFoundException {
        Equipe result = this.equipeService.findEquipe(id);
        if (result != null) {
            return result;
        } else {
            throw new ResourceNotFoundException(); // Lance une exception si l'équipe n'est pas trouvée
        }
    }

    // Endpoint pour créer une nouvelle équipe
    @PostMapping("/equipes")
    public Equipe createEquipe(@RequestBody Equipe equipe) {
        return this.equipeService.createEquipe(equipe);
    }

    // Endpoint pour supprimer une équipe par son ID
    @DeleteMapping("/equipes/{id}")
    public void deleteEquipe(@PathVariable Long id) {
        this.equipeService.deleteEquipe(id);
    }

    // Endpoint pour mettre à jour une équipe existante par son ID
    @PutMapping("/equipes/{id}")
    Equipe replaceEquipe(@RequestBody Equipe equipe, @PathVariable Long id) {
        Equipe foundEquipe = this.equipeService.findEquipe(id);
        if (foundEquipe != null) {
            // Met à jour le nom de l'équipe avec celui de la nouvelle équipe
            foundEquipe.setNom(equipe.getNom());
            foundEquipe.setJoueurs(equipe.getJoueurs());
            // Enregistre les modifications de l'équipe
            foundEquipe = this.equipeService.saveEquipe(foundEquipe);
        }
        return foundEquipe;
    }
}
