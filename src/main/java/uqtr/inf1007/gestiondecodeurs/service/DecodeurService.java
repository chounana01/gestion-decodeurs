package uqtr.inf1007.gestiondecodeurs.service;

import uqtr.inf1007.gestiondecodeurs.model.Client;
import uqtr.inf1007.gestiondecodeurs.model.Decodeur;
import uqtr.inf1007.gestiondecodeurs.repository.ClientRepository;
import uqtr.inf1007.gestiondecodeurs.repository.DecodeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class DecodeurService {

    @Autowired
    private DecodeurRepository decodeurRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<Decodeur> getDecodeursDuClient(Long clientId) {
        return decodeurRepository.findByClient_Id(clientId);
    }

    public Decodeur getById(Long id) {
        return decodeurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Decodeur non trouve"));
    }

    public Decodeur ajouterDecodeur(Long clientId, Decodeur decodeur) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouve : " + clientId));
        decodeur.setClient(client);
        decodeur.setChaines(new ArrayList<>());
        return decodeurRepository.save(decodeur);
    }

    public void supprimerDecodeur(Long id) {
        decodeurRepository.deleteById(id);
    }

    public Decodeur ajouterChaine(Long id, String chaine) {
        Decodeur d = getById(id);
        d.getChaines().add(chaine);
        return decodeurRepository.save(d);
    }

    public Decodeur retirerChaine(Long id, String chaine) {
        Decodeur d = getById(id);
        d.getChaines().remove(chaine);
        return decodeurRepository.save(d);
    }
}