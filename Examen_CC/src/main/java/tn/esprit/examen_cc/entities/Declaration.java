package tn.esprit.examen_cc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Declaration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDeclaration;

    private String description;
    private LocalDate dateDeclaration;
    private LocalDate dateTraitement;
    private boolean estTraitee;

    @ManyToOne
    @JoinColumn(name = "policier_id")
    private Utilisateur policier;

    @ManyToOne

    private Utilisateur victime;

    @OneToOne
    private Propriete propriete;
}
