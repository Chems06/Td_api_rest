package tse.app.distribue.td_api_rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tse.app.distribue.td_api_rest.model.Equipe;
import tse.app.distribue.td_api_rest.model.Joueur;
import tse.app.distribue.td_api_rest.repository.EquipeRepository;
import tse.app.distribue.td_api_rest.service.EquipeService;

import java.util.List;

@Service
@Transactional
public class EquipeServiceImpl implements EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Equipe> findAllEquipes(){
        return this.equipeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Equipe findEquipe(Long id) {
        return this.equipeRepository.findById(id).orElse(null);
    }

    @Override
    public Equipe createEquipe(Equipe equipe){
        return this.equipeRepository.save(equipe);
    }

    @Override
    public void deleteEquipe(Long id){
        this.equipeRepository.deleteById(id);
    }

    @Override
    public Equipe saveEquipe(Equipe foundEquipe){
        return this.equipeRepository.save(foundEquipe);

    }

    /*@Override
    public void addJoueur(Long id,Joueur joueur) {
        Equipe equipe = this.equipeRepository.findById(id).orElse(null);
        if (equipe!=null) {
            equipe.getJoueurs().add(joueur);
        }
        else{
            Equipe equipe1 = new Equipe();
            equipe1.setId(id);
            equipe1.getJoueurs().add(joueur);
        }
    }*/
}
