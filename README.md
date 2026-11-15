# Gestion des décodeurs

Application web Spring Boot pour gérer des clients, des décodeurs et des utilisateurs dans un contexte de câblodistributeur.

## Fonctionnalités

- Authentification d'un administrateur ou d'un utilisateur
- Gestion des clients
- Gestion des décodeurs
- Gestion des utilisateurs
- Interface web simple en HTML/CSS/JavaScript
- API REST pour les opérations principales

## Technologies

- Java 17+
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Spring Security
- MySQL
- Maven

## Prérequis

- Java installé
- Maven installé (ou utiliser le wrapper `./mvnw` inclus dans le projet)
- MySQL en marche sur la machine

## Lancer le projet

```bash
git clone https://github.com/chounana01/gestion-decodeurs.git
cd gestion-decodeurs
```

Configurer la base de données MySQL `gestion_decodeurs` (voir ci-dessous), puis lancer :

```bash
./mvnw spring-boot:run
```

## Configuration de la base de données

Le projet lit ces variables d'environnement :

- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`

Exemple sous PowerShell :

```powershell
$env:DB_URL="jdbc:mysql://localhost:3306/gestion_decodeurs?createDatabaseIfNotExist=true"
$env:DB_USERNAME="root"
$env:DB_PASSWORD="<votre-mot-de-passe>"
```
