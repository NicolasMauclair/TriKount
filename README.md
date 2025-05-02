# TriKount - API de gestion de dépenses

> **Projet personnel** visant à m'entraîner avec Spring Boot.  
> Ce projet s'inspire du fonctionnement de l'application TriCount, sans but commercial.

---

## 🚀 Technologies utilisées

- **Java 21**
- **Spring Boot 3.4.5**
- **Maven**
- **Docker**
- **PostgreSQL**
- **VSCode**

---

## 🛠️ Architecture du projet

Le projet suit une architecture classique en couches dans le package principal, organisé de la manière suivante :

- **controller** : Contient les classes qui gèrent les requêtes HTTP entrantes et renvoient les réponses.
- **service** : Contient la logique métier. Les controllers font appel aux services pour traiter les données.
- **repository** : Gère l'accès aux données. C'est ici que sont définis les accès à la base PostgreSQL via Spring Data JPA.
- **model** : Contient les entités (les classes représentant les tables de la base de données).

Cette séparation permet de garder un code clair, maintenable et évolutif.

---

## 📚 Fonctionnalités prévues

- [ ] Connexion utilisateur
- [ ] Afficher la liste des dépenses
- [ ] Afficher une dépense spécifique
- [ ] Ajouter une dépense
- [ ] Supprimer une dépense
- [ ] Confirmer le paiement d'une dépense
- [ ] (Facultatif) Calcul du montant dû par utilisateur

---

## 📡 API - Endpoints principaux

| Méthode | Endpoint | Description |
| :--- | :--- | :--- |
| GET | `/api/expenses` | Liste toutes les dépenses |
| GET | `/api/expenses/{id}` | Récupère une dépense par ID |
| POST | `/api/expenses` | Ajoute une nouvelle dépense |
| DELETE | `/api/expenses/{id}` | Supprime une dépense |
| PUT | `/api/expenses/{id}/pay` | Marque une dépense comme payée |

---

## 🏃 Lancement du projet

L'application fonctionne dans un environnement **Dockerisé** : l'API Spring Boot et la base de données PostgreSQL tournent dans des conteneurs séparés.

1. **Générer le package Maven (fichier `.jar`) :**

   ```bash
   mvn clean package
   ```
   ```bash
   docker-compose up --build
