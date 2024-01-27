package tse.app.distribue.td_api_rest.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tse.app.distribue.td_api_rest.model.Equipe;
import tse.app.distribue.td_api_rest.model.Joueur;
import tse.app.distribue.td_api_rest.repository.EquipeRepository;
import tse.app.distribue.td_api_rest.repository.JoueurRepository;
import tse.app.distribue.td_api_rest.service.EquipeService;

import java.time.LocalDate;

/**
 * Initialisation des entités
 */

@Component
public class EquipeApplicationRunner implements ApplicationRunner {

    @Autowired
    private EquipeRepository equipeRepository;
    @Autowired
    EquipeService equipeService;
    @Autowired
    private JoueurRepository joueurRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Création des équipes
        Equipe france = new Equipe();
        france.setNom("France");
        this.equipeRepository.save(france);

        Equipe maroc = new Equipe();
        maroc.setNom("Maroc");
        this.equipeRepository.save(maroc);

        Equipe japan = new Equipe();
        japan.setNom("Japan");
        this.equipeRepository.save(japan);

        // Création des joueurs
        Joueur joueurMaroc = new Joueur();
        joueurMaroc.setNom("Ayane");
        joueurMaroc.setPrenom("Rosella");
        joueurMaroc.setDateDeNaissance(LocalDate.of(1996,3,16));
        joueurMaroc.setEquipe(maroc);
        this.joueurRepository.save(joueurMaroc);

        Joueur joueurFrance = new Joueur();
        joueurFrance.setNom("Lakrar");
        joueurFrance.setPrenom("Maelle");
        joueurFrance.setDateDeNaissance(LocalDate.of(2000,5,27));
        joueurFrance.setEquipe(france);
        this.joueurRepository.save(joueurFrance);


        Joueur joueurJapan = new Joueur();
        joueurJapan.setNom("Hasegawa");
        joueurJapan.setPrenom("Yui");
        joueurJapan.setDateDeNaissance(LocalDate.of(1997,1,29));
        joueurJapan.setEquipe(japan);
        this.joueurRepository.save(joueurJapan);
    }

}


