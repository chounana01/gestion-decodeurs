package uqtr.inf1007.gestiondecodeurs.controller;

import uqtr.inf1007.gestiondecodeurs.model.Client;
import uqtr.inf1007.gestiondecodeurs.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public Client creerClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PutMapping("/{id}")
    public Client modifierClient(@PathVariable Long id, @RequestBody Client client) {
        Client existing = clientService.getById(id);
        existing.setNom(client.getNom());
        return clientService.saveClient(existing);
    }

    @DeleteMapping("/{id}")
    public void supprimerClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}