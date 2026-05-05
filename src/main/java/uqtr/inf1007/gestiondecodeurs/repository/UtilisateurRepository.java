package uqtr.inf1007.gestiondecodeurs.repository;

import uqtr.inf1007.gestiondecodeurs.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByCourriel(String courriel);
}