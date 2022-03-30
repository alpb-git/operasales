package ru.learnup.operasales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.operasales.model.AgeCategory;
import ru.learnup.operasales.model.Premiere;
import ru.learnup.operasales.repositary.PlayBill;
import ru.learnup.operasales.service.PlayBillService;

@SpringBootApplication
public class OperasalesApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(OperasalesApplication.class, args);

        PlayBill playBill = ctx.getBean(PlayBill.class);
        PlayBillService playBillService = ctx.getBean(PlayBillService.class);

        System.out.println("Init...");
        playBillService.show();

        System.out.println("\nAdd 3 items...");
        playBillService.addPremiere(new Premiere("Премьера 1", "Описание премьеры 1", AgeCategory.CATEGORY_6PLUS, 60));
        playBillService.addPremiere(new Premiere("Премьера 2", "Описание премьеры 2", AgeCategory.CATEGORY_12PLUS, 120));
        playBillService.addPremiere(new Premiere("Премьера 3", "Описание премьеры 3", AgeCategory.CATEGORY_18PLUS, 180));
        playBillService.show();

        System.out.println("\nShow 1st item...");
        System.out.println(playBill.getPremieres().get(0).toString());

        System.out.println("\nEdit 1st item...");
        playBillService.editPremiere("Премьера 1", "Новое описание премьеры 1", null);
        System.out.println(playBill.getPremieres().get(0).toString());

        System.out.println("\nRemove 3d item...");
        playBillService.removePremiere("Премьера 3");
        playBillService.show();

        System.out.println("\nBuy 10 tickets on 1st item...");
        playBillService.buyTickets("Премьера 1", 10);
        System.out.println(playBill.getPremieres().get(0).toString());

        System.out.println("\nReturn 5 tickets on 1st item...");
        playBillService.returnTickets("Премьера 1", 5);
        System.out.println(playBill.getPremieres().get(0).toString());
    }

}