package tse.app.distribue.td_api_rest.service;

import tse.app.distribue.td_api_rest.model.Joueur;

import java.util.List;

public interface JoueurService {

    public List<Joueur> findAllJoueurs();

    public Joueur findJoueur(Long id);

    public Joueur createJoueur(Joueur joueur);

    public void deleteJoueur(Long id);

    public Joueur saveJoueur(Joueur foundJoueur);
}
