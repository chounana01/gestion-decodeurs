package uqtr.inf1007.gestiondecodeurs.controller;

import uqtr.inf1007.gestiondecodeurs.model.Decodeur;
import uqtr.inf1007.gestiondecodeurs.repository.DecodeurRepository;
import uqtr.inf1007.gestiondecodeurs.service.DecodeurService;
import uqtr.inf1007.gestiondecodeurs.service.SimulateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/decodeurs")
public class DecodeurController {

    @Autowired
    private DecodeurService decodeurService;

    @Autowired
    private DecodeurRepository decodeurRepository;

    @Autowired
    private SimulateurService simulateurService;

    // Lister les decodeurs d'un client
    @GetMapping("/client/{clientId}")
    public List<Decodeur> getDecodeursDuClient(@PathVariable Long clientId) {
        return decodeurService.getDecodeursDuClient(clientId);
    }

    // Assigner un decodeur a un client
    @PostMapping("/client/{clientId}")
    public Decodeur ajouterDecodeur(@PathVariable Long clientId, @RequestBody Decodeur decodeur) {
        return decodeurService.ajouterDecodeur(clientId, decodeur);
    }

    // Retirer un decodeur
    @DeleteMapping("/{id}")
    public void supprimerDecodeur(@PathVariable Long id) {
        decodeurService.supprimerDecodeur(id);
    }

    // Obtenir l'etat d'un decodeur via le simulateur
    @GetMapping("/{id}/etat")
    public Map<String, Object> getEtat(@PathVariable Long id) {
        Decodeur d = decodeurService.getById(id);
        return simulateurService.getInfo(d.getAdresseIp());
    }

    // Redemarrer un decodeur
    @PostMapping("/{id}/reset")
    public Map<String, Object> reset(@PathVariable Long id) {
        Decodeur d = decodeurService.getById(id);
        return simulateurService.reset(d.getAdresseIp());
    }

    // Reinitialiser un decodeur
    @PostMapping("/{id}/reinit")
    public Map<String, Object> reinit(@PathVariable Long id) {
        Decodeur d = decodeurService.getById(id);
        return simulateurService.reinit(d.getAdresseIp());
    }

    // Eteindre un decodeur
    @PostMapping("/{id}/shutdown")
    public Map<String, Object> shutdown(@PathVariable Long id) {
        Decodeur d = decodeurService.getById(id);
        return simulateurService.shutdown(d.getAdresseIp());
    }

    // Ajouter une chaine a un decodeur
    @PostMapping("/{id}/chaines")
    public Decodeur ajouterChaine(@PathVariable Long id, @RequestParam String chaine) {
        return decodeurService.ajouterChaine(id, chaine);
    }
    @PutMapping("/{id}")
    public Decodeur modifierDecodeur(@PathVariable Long id, @RequestBody Decodeur decodeur) {
        Decodeur existing = decodeurService.getById(id);
        existing.setNom(decodeur.getNom());
        existing.setAdresseIp(decodeur.getAdresseIp());
        return decodeurRepository.save(existing);
    }
    // Retirer une chaine d'un decodeur
    @DeleteMapping("/{id}/chaines")
    public Decodeur retirerChaine(@PathVariable Long id, @RequestParam String chaine) {
        return decodeurService.retirerChaine(id, chaine);
    }
}