package tn.esprit.examen_cc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examen_cc.entities.Declaration;
import tn.esprit.examen_cc.entities.Propriete;

import java.util.List;
import java.util.Optional;

@Repository

public interface ProprieteRepo extends JpaRepository<Propriete,Long> {

    Optional<Propriete> findByMatricule(String matricule);
    List<Propriete> findAll();
    Propriete save(Propriete propriete);
    void deleteById(Long id);
}
