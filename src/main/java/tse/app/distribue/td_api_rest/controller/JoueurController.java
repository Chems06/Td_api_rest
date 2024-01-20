package tse.app.distribue.td_api_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tse.app.distribue.td_api_rest.Exception.ResourceNotFoundException;
import tse.app.distribue.td_api_rest.model.Joueur;
import tse.app.distribue.td_api_rest.service.JoueurService;

import java.util.List;

@RestController
public class JoueurController {
    @Autowired
    private JoueurService joueurService;

    @GetMapping("/joueurs")
    public List<Joueur> allJoueurs() {

        return this.joueurService.findAllJoueurs();
    }

    @GetMapping("/joueurs/{id}")
    public Joueur oneJoueur(@PathVariable Long id) throws ResourceNotFoundException {

        Joueur result = this.joueurService.findJoueur(id);

        if (result != null) {

            return result;
        }
        else {
            throw new ResourceNotFoundException();
        }
    }

    @PostMapping("/joueurs")
    public Joueur createJoueur(@RequestBody Joueur joueur) {

        return this.joueurService.createJoueur(joueur);
    }

    @DeleteMapping("/joueurs/{id}")
    public void deleteJoueur(@PathVariable Long id) {

        this.joueurService.deleteJoueur(id);
    }

    @PutMapping("/joueurs/{id}")
    Joueur replaceJoueur(@RequestBody Joueur joueur, @PathVariable Long id) {

        Joueur foundJoueur = this.joueurService.findJoueur(id);

        if (joueur != null) {

            foundJoueur.setName(joueur.getName());

            foundJoueur = this.joueurService.saveJoueur(foundJoueur);
        }

        return foundJoueur;
    }
}

