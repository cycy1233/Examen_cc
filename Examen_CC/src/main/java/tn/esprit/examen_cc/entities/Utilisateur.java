package tn.esprit.examen_cc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer idUtilisateur;

        private String nom;
        private String prenom;
        private String adresse;
        private Long numero;

        @Enumerated(EnumType.STRING)
        private Role role;

        @OneToMany(mappedBy = "policier")
        private Set<Declaration> policiers;

        @OneToMany(mappedBy = "victime")
        private Set<Declaration> victimes;
}
