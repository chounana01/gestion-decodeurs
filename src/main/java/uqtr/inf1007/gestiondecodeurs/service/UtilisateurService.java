package uqtr.inf1007.gestiondecodeurs.service;

import uqtr.inf1007.gestiondecodeurs.model.Utilisateur;
import uqtr.inf1007.gestiondecodeurs.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Utilisateur creerUtilisateur(Utilisateur u) {
        u.setMotDePasse(passwordEncoder.encode(u.getMotDePasse()));
        return utilisateurRepository.save(u);
    }

    public List<Utilisateur> getTous() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur findByCourriel(String courriel) {
        return utilisateurRepository.findByCourriel(courriel).orElse(null);
    }

    public void supprimer(Long id) {
        utilisateurRepository.deleteById(id);
    }
}