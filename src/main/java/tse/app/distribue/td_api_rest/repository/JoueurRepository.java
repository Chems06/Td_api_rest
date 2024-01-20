package tse.app.distribue.td_api_rest.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import tse.app.distribue.td_api_rest.model.Joueur;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {

}

