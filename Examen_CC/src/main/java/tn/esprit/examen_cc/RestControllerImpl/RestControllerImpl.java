package tn.esprit.examen_cc.RestControllerImpl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.examen_cc.entities.Declaration;
import tn.esprit.examen_cc.entities.Propriete;
import tn.esprit.examen_cc.entities.Utilisateur;
import tn.esprit.examen_cc.services.IService;
import tn.esprit.examen_cc.services.ServiceImpl;


import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/vol-rest-controller/")
public class RestControllerImpl {
    IService service;
    @PostMapping("/victime")
    Utilisateur ajouterVictime(@RequestBody Utilisateur victime) {
        return service.ajouterVictime(victime);
    }
    @PostMapping("/policiers")
    String ajouterPoliciers(@RequestBody List<Utilisateur> policiers) {
        return service.ajouterPoliciers(policiers);
    }
    @PostMapping("/declaration")
    public String ajouterDeclarationEtAffecterAVictime(@RequestBody Declaration declaration, @RequestParam long telephone) {
        return service.ajouterDeclarationEtAffecterAVictime(declaration, telephone);
    }

    @PostMapping("/ajouter-declaration-et-affecter-a-victime/{telephone}")
    public ResponseEntity<String> ajouterDeclarationEtAffecterAVictime(
            @RequestBody Declaration declaration, @PathVariable String telephone) {
        String message = service.ajouterDeclarationEtAffecterAVictime(declaration, telephone);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/affecter-policier-a-declaration/{idUtilisateur}/{idDeclaration}")
    public ResponseEntity<Void> affecterPolicierADeclaration(
            @PathVariable long idUtilisateur, @PathVariable long idDeclaration) {
        service.affecterPolicierADeclaration(idUtilisateur, idDeclaration);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/affecter-declaration-a-victime/{idDeclaration}/{telephone}")
    public ResponseEntity<Void> affecterDeclarationAVictime(
            @PathVariable long idDeclaration, @PathVariable String telephone) {
        service.affecterDeclarationAVictime(idDeclaration, telephone);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/affecter-declaration-a-policier/{idDeclaration}/{idUtilisateur}")
    public ResponseEntity<Void> affecterDeclarationAPolicier(
            @PathVariable long idDeclaration, @PathVariable long idUtilisateur) {
        service.affecterDeclarationAPolicier(idDeclaration, idUtilisateur);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-utilisateur/{telephone}")
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable String telephone) {
        Utilisateur utilisateur = service.getUtilisateur(telephone);
        if (utilisateur == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(utilisateur);
    }

    @GetMapping("/get-declarations-victime/{telephone}")
    public ResponseEntity<List<Declaration>> getDeclarationsVictime(@PathVariable String telephone) {
        Utilisateur utilisateur = Service.getUtilisateur(telephone);
        if (utilisateur == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(utilisateur.getDeclarationsVictime());
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Declaration> ajouterDeclaration(@RequestBody Declaration declaration) {
        Declaration newDeclaration = declarationService.ajouterDeclaration(declaration);
        return ResponseEntity.ok(newDeclaration);
    }

    @GetMapping("/traitees")
    public ResponseEntity<List<Declaration>> getDeclarationsTraitees() {
        List<Declaration> declarations = service.getDeclarationsTraitees();
        return ResponseEntity.ok(declarations);
    }

    @GetMapping("/non-traitees")
    public ResponseEntity<List<Declaration>> getDeclarationsNonTraitees() {
        List<Declaration> declarations = service.getDeclarationsNonTraitees();
        return ResponseEntity.ok(declarations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Declaration> getDeclaration(@PathVariable long id) {
        Declaration declaration = service.getDeclaration(id);
        if (declaration == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(declaration);
    }

    @PutMapping("/traiter-manuellement/{id}")
    public ResponseEntity<Void> traiterDeclarationManuellement(@PathVariable long id) {
        service.traiterDeclarationManuellement(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/traiter-automatiquement")
    public ResponseEntity<Void> traiterDeclarationAutomatiquement() {
        service.traiterDeclarationAutomatiquement();
        return ResponseEntity.ok().build();
    }


    @GetMapping("/afficher-traites")
    public ResponseEntity<List<Declaration>> afficherDeclarationsTraitees() {
        List<Declaration> declarations = service.afficherDeclarationsTraitees();
        return ResponseEntity.ok(declarations);
    }

    @GetMapping
    public ResponseEntity<List<Propriete>> getAllProprietes() {
        List<Propriete> proprietes = service.getAllProprietes();
        return ResponseEntity.ok(proprietes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propriete> getProprieteById(@PathVariable Long id) {
        Optional<Propriete> propriete = service.getProprieteById(id);
        return propriete.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Propriete> saveOrUpdatePropriete(@RequestBody Propriete propriete) {
        Propriete savedPropriete = service.savePropriete(propriete);
        return ResponseEntity.ok(savedPropriete);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProprieteById(@PathVariable Long id) {
        service.deleteProprieteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Propriete> updatePropriete(@PathVariable Long id, @RequestBody Propriete propriete) {
        if (!proprieteService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        propriete.setId(id);
        Propriete updatedPropriete = proprieteService.saveOrUpdatePropriete(propriete);
        return ResponseEntity.ok(updatedPropriete);
    }
    @GetMapping("/par-matricule/{matricule}")
    public ResponseEntity<Propriete> recupererProprieteParMatricule(@PathVariable String matricule) {
        Optional<Propriete> propriete = service.recupererProprieteParMatricule(matricule);
        return propriete.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
