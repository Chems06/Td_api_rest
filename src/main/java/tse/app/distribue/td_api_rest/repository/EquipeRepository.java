package tse.app.distribue.td_api_rest.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import tse.app.distribue.td_api_rest.model.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}

