package tn.esprit.examen_cc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examen_cc.entities.Declaration;

import java.util.Date;
import java.util.List;

@Repository

public interface DeclarationRepo extends JpaRepository<Declaration,Long> {
    List<Declaration> findByDateDeclarationBeforeAndEstTraiteeFalse(Date date);


    List<Declaration> findByEstTraitee(boolean b);

    List<Declaration> findByEstTraiteeFalse();

    List<Declaration> findByEstTraiteeTrue();
}
