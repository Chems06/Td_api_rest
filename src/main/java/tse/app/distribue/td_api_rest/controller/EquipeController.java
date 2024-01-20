package tse.app.distribue.td_api_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tse.app.distribue.td_api_rest.Exception.ResourceNotFoundException;
import tse.app.distribue.td_api_rest.model.Equipe;
import tse.app.distribue.td_api_rest.service.EquipeService;

import java.util.List;

@RestController
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @GetMapping("/equipes")
    public List<Equipe> allEquipes() {

        return this.equipeService.findAllEquipes();
    }

    @GetMapping("/equipes/{id}")
    public Equipe oneEquipe(@PathVariable Long id) throws ResourceNotFoundException {

        Equipe result = this.equipeService.findEquipe(id);

        if (result != null) {

            return result;
        }
        else {
            throw new ResourceNotFoundException();
        }
    }

    @PostMapping("/equipes")
    public Equipe createEquipe(@RequestBody Equipe equipe) {

        return this.equipeService.createEquipe(equipe);
    }

    @DeleteMapping("/equipes/{id}")
    public void deleteEquipe(@PathVariable Long id) {

        this.equipeService.deleteEquipe(id);
    }

    @PutMapping("/equipes/{id}")
    Equipe replaceEquipe(@RequestBody Equipe equipe, @PathVariable Long id) {

        Equipe foundEquipe = this.equipeService.findEquipe(id);

        if (equipe != null) {

            foundEquipe.setName(equipe.getName());

            foundEquipe = this.equipeService.saveEquipe(foundEquipe);
        }

        return foundEquipe;
    }
}
