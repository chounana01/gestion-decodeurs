package uqtr.inf1007.gestiondecodeurs.controller;

import uqtr.inf1007.gestiondecodeurs.model.Client;
import uqtr.inf1007.gestiondecodeurs.model.Utilisateur;
import uqtr.inf1007.gestiondecodeurs.repository.ClientRepository;
import uqtr.inf1007.gestiondecodeurs.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String courriel = body.get("courriel");
        String motDePasse = body.get("motDePasse");

        Utilisateur u = utilisateurService.findByCourriel(courriel);
        if (u == null || !passwordEncoder.matches(motDePasse, u.getMotDePasse())) {
            return ResponseEntity.status(401).body("Identifiants incorrects");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("id", u.getId());
        response.put("nom", u.getNom());
        response.put("courriel", u.getCourriel());
        response.put("role", u.getRole());
        if (u.getClientAssocie() != null) {
            response.put("clientId", u.getClientAssocie().getId());
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> body) {
        String courriel = (String) body.get("courriel");
        Utilisateur exist = utilisateurService.findByCourriel(courriel);
        if (exist != null) {
            return ResponseEntity.status(400).body("Courriel deja utilise");
        }

        Utilisateur u = new Utilisateur();
        u.setNom((String) body.get("nom"));
        u.setCourriel(courriel);
        u.setMotDePasse((String) body.get("motDePasse"));
        u.setRole((String) body.getOrDefault("role", "USER"));

        // Lier au client si fourni
        Object clientIdObj = body.get("clientId");
        if (clientIdObj != null) {
            Long clientId = Long.valueOf(clientIdObj.toString());
            Client client = clientRepository.findById(clientId).orElse(null);
            u.setClientAssocie(client);
        }

        Utilisateur saved = utilisateurService.creerUtilisateur(u);
        return ResponseEntity.ok(Map.of(
                "id", saved.getId(),
                "nom", saved.getNom(),
                "courriel", saved.getCourriel(),
                "role", saved.getRole()
        ));
    }
}