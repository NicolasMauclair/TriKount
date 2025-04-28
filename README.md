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
