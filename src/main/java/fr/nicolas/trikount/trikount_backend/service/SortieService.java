package fr.nicolas.trikount.trikount_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nicolas.trikount.trikount_backend.DTO.SortieDTO;
import fr.nicolas.trikount.trikount_backend.model.Sortie;
import fr.nicolas.trikount.trikount_backend.model.User;
import fr.nicolas.trikount.trikount_backend.repository.SortieRepository;
import fr.nicolas.trikount.trikount_backend.repository.UserRepository;

@Service
public class SortieService {

    @Autowired
    private SortieRepository sortieRepository;

    @Autowired
    private UserRepository userRepository;

    // Méthode pour créer une sortie
    public SortieDTO createSortie(Long userId, String groupName, List<Long> userIds) {

        User creator = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));

        Sortie newSortie = new Sortie(groupName);
        newSortie.setCreatedBy(creator);
        creator.getCreatedSorties().add(newSortie);

        for (Long id : userIds) {

            // vérifie si l'utilisateur n'est pas déjà dans la sortie
            if (newSortie.getUsers().stream().anyMatch(user -> user.getId().equals(id))) {
                User user = userRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));

                newSortie.getUsers().add(user);
                user.getJoinedSorties().add(newSortie);
            }
        }

        return new SortieDTO(sortieRepository.save(newSortie));
    }

    // Méthode pour récupérer une sortie à partir de son id
    public SortieDTO getSortie(Long id) {
        return new SortieDTO(
                sortieRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Sortie non trouvée")));
    }

    // Méthode pour récupérer toutes les sorties
    public List<SortieDTO> getAllSortie() {
        return sortieRepository.findAll().stream()
                .map(SortieDTO::new)
                .toList();
    }

    // Ajouter un utilisateur à une sortie
    public Sortie addUserToSortie(Long userID, Long sortieID) {
        User user = userRepository.findById(userID)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));

        Sortie sortie = sortieRepository.findById(sortieID)
                .orElseThrow(() -> new IllegalArgumentException("Sortie non trouvée"));

        sortie.getUsers().add(user);
        user.getJoinedSorties().add(sortie);
        return sortieRepository.save(sortie);
    }

    // Méthode pour supprimer une sortie
    public boolean deleteSortieIfCreator(Long idSortie, Long idUser) {
        Optional<Sortie> sortieOpt = sortieRepository.findById(idSortie);
        if (sortieOpt.isPresent()) {
            Sortie sortie = sortieOpt.get();
            if (sortie.getCreatedBy().getId().equals(idUser)) {
                sortieRepository.delete(sortie);
                return true;
            }
        }
        return false;
    }

}
