package tn.esprit.examen_cc.services;

import tn.esprit.examen_cc.entities.Declaration;
import tn.esprit.examen_cc.entities.Utilisateur;

import java.util.List;

public interface IService {
    Utilisateur ajouterVictime(Utilisateur victime);
    String ajouterPoliciers(List<Utilisateur> policiers);
    String ajouterDeclarationEtAffecterAVictime(Declaration declaration, long telephone);
    void affecterPolicierADeclarataion(long idUtilisateur, long idDeclarataion);
    List<Utilisateur> afficherDeclarationsTraitees();
    void affecterDeclarationAVictime(Long idDeclaration, Long telephone);
    void affecterPolicierADeclarataion(long idUtilisateur, long idDeclarataion);

    void traiterDeclarationAutomatiquement();

    List<Utilisateur> afficherDeclarationsTraitees();


}
