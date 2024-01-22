package tse.app.distribue.td_api_rest.application;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tse.app.distribue.td_api_rest.model.Equipe;
import tse.app.distribue.td_api_rest.model.Joueur;
import tse.app.distribue.td_api_rest.repository.EquipeRepository;
import tse.app.distribue.td_api_rest.repository.JoueurRepository;
import tse.app.distribue.td_api_rest.service.EquipeService;

import java.util.List;

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


        Equipe equipe1 = new Equipe();
        equipe1.setName("equipe1");

        this.equipeRepository.save(equipe1);

        Equipe equipe2 = new Equipe();
        equipe2.setName("equipe2");
        this.equipeRepository.save(equipe2);

        Equipe equipe3 = new Equipe();
        equipe3.setName("equipe3");
        this.equipeRepository.save(equipe3);


        Joueur joueur1 = new Joueur();
        joueur1.setName("joueur1");
        joueur1.setSurname("joueur1");
        joueur1.setEquipe(equipe1);
        this.joueurRepository.save(joueur1);

        Joueur joueur2 = new Joueur();
        joueur2.setName("joueur2");
        joueur2.setSurname("joueur2");
        joueur2.setEquipe(equipe1);
        this.joueurRepository.save(joueur2);



        //equipe1.setJoueurs(List.of(joueur1));
    }

}

