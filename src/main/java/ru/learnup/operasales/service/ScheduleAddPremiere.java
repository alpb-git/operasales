package ru.learnup.operasales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.learnup.operasales.model.AgeCategory;
import ru.learnup.operasales.model.Premiere;

@Service
public class ScheduleAddPremiere {

    private final PremiereService premiereService;

    @Autowired
    public ScheduleAddPremiere(PremiereService premiereService) {
        this.premiereService = premiereService;
    }

    @Scheduled(fixedRate = 1000)
    @Async
    public void schedule() {
        System.out.println("running AddPremiere...");
        premiereService.addPremiere(new Premiere("Новая премьера", "Описание новой премьеры", AgeCategory.CATEGORY_6PLUS, 60));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}