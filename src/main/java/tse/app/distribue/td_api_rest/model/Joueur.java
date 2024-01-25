package tse.app.distribue.td_api_rest.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")*/
@Entity
@Data
@NoArgsConstructor
public class Joueur {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
}

