package tn.esprit.examen_cc.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen_cc.entities.Declaration;
import tn.esprit.examen_cc.entities.Role;
import tn.esprit.examen_cc.entities.Utilisateur;
import tn.esprit.examen_cc.repositories.DeclarationRepo;
import tn.esprit.examen_cc.repositories.ProprieteRepo;
import tn.esprit.examen_cc.repositories.UtilisateurRepo;
import tn.esprit.examen_cc.services.IService;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceImpl implements IService {
    DeclarationRepo declarationRepo;
    UtilisateurRepo utilisateurRepo;
    ProprieteRepo proprieteRepo;

    @Override
    public Utilisateur ajouterVictime(Utilisateur victime) {
        if (victime.getRole() != Role.VICTIME) {
            return new Utilisateur();
        }
        return utilisateurRepo.save(victime);
    }

    @Override
    public String ajouterPoliciers(List<Utilisateur> policiers) {
        int nbrP = 0;
        for (Utilisateur policier : policiers) {
            if (policier.getRole() == Role.POLICIER) {
                utilisateurRepo.save(policier);
                nbrP++;
            }
        }
        return nbrP + " policiers sont ajoutés avec succès !";
    }

    @Override
    public void affecterPolicierADeclarataion(long idUtilisateur, long idDeclarataion) {
  /*      Optional<Utilisateur> optionalVictime = utilisateurRepo.findByTelephone(telephone);
        if (optionalVictime.isPresent()) {
            Utilisateur victime = optionalVictime.get();
            if (victime.getRole() == Role.VICTIME) {
                Propriete propriete = declaration.getPropriete();
                proprieteRepo.save(propriete);
                declaration.setVictime(victime);
                declarationRepo.save(declaration);
                return "Déclaration ajoutée avec succès et affectée à la victime " + victime.getNom() + " " + victime.getPrenom();
            }
        }
        return "Victime non trouvée ou numéro de téléphone incorrect.";
   */ }


    @Override
    public List<Utilisateur> afficherDeclarationsTraitees() {
        return null;
    }

    @Override
    public String ajouterDeclarationEtAffecterAVictime(Declaration declaration, long telephone) {
        return null;
    }
}
