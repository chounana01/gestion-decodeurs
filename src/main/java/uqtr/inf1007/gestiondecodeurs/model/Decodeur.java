package uqtr.inf1007.gestiondecodeurs.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "decodeurs")
public class Decodeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String adresseIp;

    private String statut = "Actif";

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "decodeur_chaines", joinColumns = @JoinColumn(name = "decodeur_id"))
    @Column(name = "chaine")
    private List<String> chaines = new ArrayList<>();
}