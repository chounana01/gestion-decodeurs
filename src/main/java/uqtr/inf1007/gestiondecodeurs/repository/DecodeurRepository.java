package uqtr.inf1007.gestiondecodeurs.repository;

import uqtr.inf1007.gestiondecodeurs.model.Decodeur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DecodeurRepository extends JpaRepository<Decodeur, Long> {
    List<Decodeur> findByClient_Id(Long clientId);
}