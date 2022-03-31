package ru.learnup.operasales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.operasales.annotations.EmailNotified;
import ru.learnup.operasales.model.AgeCategory;
import ru.learnup.operasales.model.Premiere;
import ru.learnup.operasales.repositary.PlayBill;

@Service
public class PlayBillService {

    private final PlayBill playBill;

    @Autowired
    public PlayBillService(PlayBill playBill) {
        this.playBill = playBill;
    }

    public Premiere getPremiereByName(String namePremiere) {
        for (Premiere p : playBill.getPremieres()) {
            if (p.getName().equalsIgnoreCase(namePremiere)) {
                return p;
            }
        }
        return null;
    }

    @EmailNotified
    public void addPremiere(Premiere premiere) {
        if (getPremiereByName(premiere.getName()) != null) {
            throw new RuntimeException("Премьера '" + premiere.getName() + "' уже добавлена в афишу");
        }
        playBill.getPremieres().add(premiere);
    }

    public void editPremiere(String namePremiere, String description, AgeCategory ageCategory) {
        Premiere premiere = getPremiereByName(namePremiere);
        if (premiere != null) {
            if (description != null) {
                premiere.setDescription(description);
            }
            if (ageCategory != null) {
                premiere.setAgeCategory(ageCategory);
            }
        }
    }

    @EmailNotified
    public void removePremiere(String namePremiere) {
        Premiere premiere = getPremiereByName(namePremiere);
        if (premiere != null) {
            playBill.getPremieres().remove(premiere);
        }
    }

    public void show() {
        if (playBill.getPremieres().isEmpty()) {
            System.out.println("Пустая афиша");
        } else {
            playBill.getPremieres().forEach((p) -> {
                System.out.println(p.getName());
            });
        }
    }

    @EmailNotified
    public void buyTickets(String namePremiere, int numberOfTickets) {
        Premiere premiere = getPremiereByName(namePremiere);
        if (premiere != null) {
            int numberOfSeatsFree = premiere.getNumberOfSeats() - premiere.getNumberOfSeatsSold();
            if (numberOfSeatsFree < numberOfTickets) {
                throw new RuntimeException("На премьеру '" + namePremiere + "' доступных к продаже мест " + numberOfSeatsFree);
            }
            premiere.setNumberOfSeatsSold(premiere.getNumberOfSeatsSold() + numberOfTickets);
        }
    }

    public void returnTickets(String namePremiere, int numberOfTickets) {
        Premiere premiere = getPremiereByName(namePremiere);
        if (premiere != null) {
            int numberOfSeatsSold = premiere.getNumberOfSeatsSold();
            if (numberOfSeatsSold < numberOfTickets) {
                throw new RuntimeException("На премьеру '" + premiere.getName() + "' доступных к возврату билетов " + numberOfSeatsSold);
            }
            premiere.setNumberOfSeatsSold(numberOfSeatsSold - numberOfTickets);
        }
    }

}