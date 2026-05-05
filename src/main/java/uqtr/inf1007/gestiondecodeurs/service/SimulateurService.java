package uqtr.inf1007.gestiondecodeurs.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.Map;
import java.util.HashMap;

@Service
public class SimulateurService {

    private static final String URL = "https://wflageol-uqtr.net/decoder";
    private static final String CODE_PERMANENT = "CISK65370100";

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> envoyerCommande(String adresseIp, String action) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> body = new HashMap<>();
        body.put("id", CODE_PERMANENT);
        body.put("address", adresseIp);
        body.put("action", action);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(URL, request, Map.class);
        return response.getBody();
    }

    public Map<String, Object> getInfo(String adresseIp) {
        return envoyerCommande(adresseIp, "info");
    }

    public Map<String, Object> reset(String adresseIp) {
        return envoyerCommande(adresseIp, "reset");
    }

    public Map<String, Object> reinit(String adresseIp) {
        return envoyerCommande(adresseIp, "reinit");
    }

    public Map<String, Object> shutdown(String adresseIp) {
        return envoyerCommande(adresseIp, "shutdown");
    }
}