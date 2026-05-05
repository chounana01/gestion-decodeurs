package uqtr.inf1007.gestiondecodeurs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false, unique = true)
    private String courriel;

    @JsonIgnore
    @Column(nullable = false)
    private String motDePasse;

    private String role = "USER";

    private boolean actif = true;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientAssocie;
}