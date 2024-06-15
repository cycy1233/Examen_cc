package tn.esprit.examen_cc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Propriete {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long idPropriete;
        String couleur;
        String marque;
        String matricule;
        String numSerie;

        @Enumerated(EnumType.STRING)
        TypePropriete typePropriete;


}
