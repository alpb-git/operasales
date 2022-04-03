package ru.learnup.operasales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.learnup.operasales.model.AgeCategory;
import ru.learnup.operasales.model.Premiere;

@Service
public class ScheduleRemovePremiere {

    private final PremiereService premiereService;

    @Autowired
    public ScheduleRemovePremiere(PremiereService premiereService) {
        this.premiereService = premiereService;
    }

    @Scheduled(fixedRate = 3000)
    @Async
    public void schedule() {
        System.out.println("running RemovePremiere...");
        premiereService.removePremiere("Новая премьера");

    }

}