package ru.learnup.operasales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.operasales.model.Premiere;
import ru.learnup.operasales.repository.PremiereRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PremiereService {

    private final PremiereRepository premiereRepository;

    @Autowired
    public PremiereService(PremiereRepository premiereRepository) {
        this.premiereRepository = premiereRepository;
    }

    public List<Premiere> findAll() {
        return premiereRepository.findAll();
    }

    public Premiere findById(Long id) {
        return premiereRepository.findById(id).orElse(null);
    }

    @Transactional
    public String addPremiere(Premiere premiere) {
        if (premiereRepository.getPremiereByName(premiere.getName()) != null) {
            return "Премьера '" + premiere.getName() + "' УЖЕ добавлена в афишу";
        }
        premiereRepository.save(premiere);
        System.out.println("Премьера '" + premiere.getName() + "' успешно добавлена в афишу");
        return null;
    }

    @Transactional
    public String editPremiere(Long id, String description, String ageCategory) {
        Premiere premiere = this.findById(id);
        if (premiere == null) {
            return "Премьера ID='" + id + "' НЕ найдена в афише";
        }
        if (description != null) {
            premiere.setDescription(description);
        }
        if (ageCategory != null) {
            premiere.setAgeCategory(ageCategory);
        }
        premiereRepository.save(premiere);
        return null;
    }

    @Transactional
    public String removePremiere(Long id) {
        Premiere premiere = this.findById(id);
        if (premiere == null) {
            return "Премьера ID='" + id + "' НЕ найдена в афише";
        }
        premiereRepository.delete(premiere);
        return null;
    }

}