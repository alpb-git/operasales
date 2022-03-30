package ru.learnup.operasales.repositary;

import org.springframework.stereotype.Repository;
import ru.learnup.operasales.model.Premiere;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayBill {

    private List<Premiere> premieres = new ArrayList<>();

    public PlayBill() {
    }

    public List<Premiere> getPremieres() {
        return premieres;
    }

}