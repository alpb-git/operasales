package ru.learnup.operasales.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
@Service
public class Schedule {
    @Scheduled(fixedDelayString = "5000")
    public void schedule() {
        System.out.println("running...");
    }

}