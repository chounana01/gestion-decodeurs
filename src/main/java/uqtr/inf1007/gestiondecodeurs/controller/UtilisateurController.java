package uqtr.inf1007.gestiondecodeurs.controller;

import uqtr.inf1007.gestiondecodeurs.model.Utilisateur;
import uqtr.inf1007.gestiondecodeurs.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> getTous() {
        return utilisateurService.getTous();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimer(@PathVariable Long id) {
        utilisateurService.supprimer(id);
        return ResponseEntity.ok("Utilisateur supprimé");
    }
}