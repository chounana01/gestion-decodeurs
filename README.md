# Gestion des Decodeurs

Application web Spring Boot pour gerer des clients, des decodeurs et des utilisateurs dans un contexte de cablodistributeur.

## Fonctionnalites

- Authentification d'un administrateur ou d'un utilisateur
- Gestion des clients
- Gestion des decodeurs
- Gestion des utilisateurs
- Interface web simple en HTML/CSS/JavaScript
- API REST pour les operations principales

## Technologies

- Java 17+
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Spring Security
- MySQL
- Maven

## Prerequis

- Java installe
- Maven installe
- MySQL en marche sur la machine

## Configuration de la base de donnees

Le projet utilise une base MySQL nommee `gestion_decodeurs`.

Exemple de configuration locale :

- utilisateur : `root`
- mot de passe : votre mot de passe MySQL

Le projet lit ces variables d'environnement :

- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`

Exemple sous PowerShell :

```powershell
$env:DB_URL="jdbc:mysql://localhost:3306/gestion_decodeurs?createDatabaseIfNotExist=true"
$env:DB_USERNAME="root"
$env:DB_PASSWORD="VotreMotDePasse"
