package tse.app.distribue.td_api_rest.service;

import tse.app.distribue.td_api_rest.model.Equipe;

import java.util.List;

public interface EquipeService {

    List<Equipe> findAllEquipes();

    Equipe findEquipe(Long id);

    Equipe createEquipe(Equipe equipe);

    void deleteEquipe(Long id);

    Equipe saveEquipe(Equipe foundEquipe);

}
