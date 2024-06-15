package tn.esprit.examen_cc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examen_cc.entities.Declaration;
import tn.esprit.examen_cc.entities.Role;
import tn.esprit.examen_cc.entities.Utilisateur;

@Repository

public interface UtilisateurRepo extends JpaRepository<Utilisateur,Long> {


    Utilisateur findByTelephone(String telephone);


    Utilisateur findByTelephoneAndRole(String telephone, Role role);

    Utilisateur findByIdAndRole(long idUtilisateur, Role role);
}
