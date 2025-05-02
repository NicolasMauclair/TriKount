package fr.nicolas.trikount.trikount_backend.service;

import fr.nicolas.trikount.trikount_backend.model.Sortie;
import fr.nicolas.trikount.trikount_backend.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import fr.nicolas.trikount.trikount_backend.repository.DepenceRepository;

@Service
public class DepenceService {

    @Autowired
    private DepenceRepository DepenceRepository;

    
}
