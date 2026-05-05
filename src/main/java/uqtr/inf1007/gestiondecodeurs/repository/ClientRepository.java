package uqtr.inf1007.gestiondecodeurs.repository;

import uqtr.inf1007.gestiondecodeurs.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}