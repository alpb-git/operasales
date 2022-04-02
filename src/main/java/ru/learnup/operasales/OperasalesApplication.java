package ru.learnup.operasales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.operasales.model.AgeCategory;
import ru.learnup.operasales.model.Premiere;
import ru.learnup.operasales.service.PremiereService;

@SpringBootApplication
public class OperasalesApplication {

    /**
     * Добавлен пустой шедулер, чтобы не гасить приложение и мониторить состояние БД H2
     * http://localhost:8080/h2-console
     */

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(OperasalesApplication.class, args);

        PremiereService premiereService = ctx.getBean(PremiereService.class);

        System.out.println("Init...");
        premiereService.printAll();

        System.out.println("\nAdd 3 items...");
        premiereService.addPremiere(new Premiere("Премьера 1", "Описание премьеры 1", AgeCategory.CATEGORY_6PLUS, 60));
        premiereService.addPremiere(new Premiere("Премьера 2", "Описание премьеры 2", AgeCategory.CATEGORY_12PLUS, 120));
        premiereService.addPremiere(new Premiere("Премьера 3", "Описание премьеры 3", AgeCategory.CATEGORY_18PLUS, 180));
        premiereService.printAll();

        System.out.println("\nShow 1st item...");
        System.out.println(premiereService.printById(1L).toString());

        System.out.println("\nEdit 1st item...");
        premiereService.editPremiere("Премьера 1", "Новое описание премьеры 1", null);
        System.out.println(premiereService.printById(1L).toString());

        System.out.println("\nRemove 3d item...");
        premiereService.removePremiere("Премьера 3");
        premiereService.printAll();

        System.out.println("\nBuy 10 tickets on 1st item...");
        premiereService.buyTickets("Премьера 1", 10);
        System.out.println(premiereService.printById(1L).toString());

        System.out.println("\nReturn 5 tickets on 1st item...");
        premiereService.returnTickets("Премьера 1", 5);
        System.out.println(premiereService.printById(1L).toString());
    }

}