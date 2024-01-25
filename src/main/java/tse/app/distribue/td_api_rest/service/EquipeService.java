package tse.app.distribue.td_api_rest.service;

import tse.app.distribue.td_api_rest.model.Equipe;
import tse.app.distribue.td_api_rest.model.Joueur;

import java.util.List;

public interface EquipeService {

    public List<Equipe> findAllEquipes();

    public Equipe findEquipe(Long id);

    public Equipe createEquipe(Equipe equipe);

    public void deleteEquipe(Long id);

    public Equipe saveEquipe(Equipe foundEquipe);

    //public void addJoueur(Long id,Joueur joueur);

}
