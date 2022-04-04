package ru.learnup.operasales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.operasales.model.AgeCategory;
import ru.learnup.operasales.model.Premiere;
import ru.learnup.operasales.service.PremiereService;

@SpringBootApplication
public class OperasalesApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(OperasalesApplication.class, args);

        PremiereService premiereService = ctx.getBean(PremiereService.class);

        System.out.println("\nAdd 3 items...");
        premiereService.addPremiere(new Premiere("Премьера 1", "Описание премьеры 1", AgeCategory.CATEGORY_6PLUS.getName(), 60));
        premiereService.addPremiere(new Premiere("Премьера 2", "Описание премьеры 2", AgeCategory.CATEGORY_12PLUS.getName(), 120));
        premiereService.addPremiere(new Premiere("Премьера 3", "Описание премьеры 3", AgeCategory.CATEGORY_18PLUS.getName(), 180));

    }

}