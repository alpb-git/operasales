package ru.learnup.operasales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.operasales.annotations.EmailNotified;
import ru.learnup.operasales.model.AgeCategory;
import ru.learnup.operasales.model.Premiere;
import ru.learnup.operasales.repository.PremiereRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PremiereService {

    private final PremiereRepository premiereRepository;

    @Autowired
    public PremiereService(PremiereRepository premiereRepository) {
        this.premiereRepository = premiereRepository;
    }

    @EmailNotified
    public void addPremiere(Premiere premiere) {
        if (premiereRepository.findPremiereByName(premiere.getName()) != null) {
            throw new RuntimeException("Премьера '" + premiere.getName() + "' уже добавлена в афишу");
        }
        premiereRepository.save(premiere);
    }

    public void editPremiere(String namePremiere, String description, AgeCategory ageCategory) {
        Premiere premiere = premiereRepository.findPremiereByName(namePremiere);
        if (premiere != null) {
            if (description != null) {
                premiere.setDescription(description);
            }
            if (ageCategory != null) {
                premiere.setAgeCategory(ageCategory);
            }
            premiereRepository.save(premiere);
        }
    }

    @EmailNotified
    public void removePremiere(String namePremiere) {
        Premiere premiere = premiereRepository.findPremiereByName(namePremiere);
        if (premiere != null) {
            premiereRepository.delete(premiere);
        }
    }

    public void printAll() {
        List<Premiere> premieres = premiereRepository.findAll();

        if (premieres.isEmpty()) {
            System.out.println("Пустая афиша");
        } else {
            premieres.forEach((p) -> {
                System.out.println(p.getName());
            });
        }
    }

    public Premiere printById(Long id) {
        Optional<Premiere> premiere = premiereRepository.findById(id);
        return premiere.orElse(null);
    }

    @EmailNotified
    public void buyTickets(String namePremiere, int numberOfTickets) {
        Premiere premiere = premiereRepository.findPremiereByName(namePremiere);
        if (premiere != null) {
            int numberOfSeatsFree = premiere.getNumberOfSeats() - premiere.getNumberOfSeatsSold();
            if (numberOfSeatsFree < numberOfTickets) {
                throw new RuntimeException("На премьеру '" + namePremiere + "' доступных к продаже мест " + numberOfSeatsFree);
            }
            premiere.setNumberOfSeatsSold(premiere.getNumberOfSeatsSold() + numberOfTickets);
            premiereRepository.save(premiere);
        }
    }

    public void returnTickets(String namePremiere, int numberOfTickets) {
        Premiere premiere = premiereRepository.findPremiereByName(namePremiere);
        if (premiere != null) {
            int numberOfSeatsSold = premiere.getNumberOfSeatsSold();
            if (numberOfSeatsSold < numberOfTickets) {
                throw new RuntimeException("На премьеру '" + premiere.getName() + "' доступных к возврату билетов " + numberOfSeatsSold);
            }
            premiere.setNumberOfSeatsSold(numberOfSeatsSold - numberOfTickets);
            premiereRepository.save(premiere);
        }
    }

}