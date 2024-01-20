package tse.app.distribue.td_api_rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tse.app.distribue.td_api_rest.model.Joueur;
import tse.app.distribue.td_api_rest.repository.JoueurRepository;
import tse.app.distribue.td_api_rest.service.JoueurService;

import java.util.List;

@Service
public class JoueurServiceImpl implements JoueurService {

    @Autowired
    private JoueurRepository joueurRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Joueur> findAllJoueurs(){
        return this.joueurRepository.findAll();
    };

    @Override
    @Transactional(readOnly = true)
    public Joueur findJoueur(Long id){
        return this.joueurRepository.findById(id).orElse(null);
    };

    @Override
    public Joueur createJoueur(Joueur joueur){
        return this.joueurRepository.save(joueur);
    };

    @Override
    public void deleteJoueur(Long id){
        this.joueurRepository.deleteById(id);
    };

    @Override
    public Joueur saveJoueur(Joueur foundJoueur){
        return this.joueurRepository.save(foundJoueur);
    };
}
