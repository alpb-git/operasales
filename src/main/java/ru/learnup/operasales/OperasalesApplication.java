package ru.learnup.operasales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.learnup.operasales.model.AgeCategory;
import ru.learnup.operasales.model.DbUser;
import ru.learnup.operasales.model.Premiere;
import ru.learnup.operasales.model.User;
import ru.learnup.operasales.repository.DbUserRepository;
import ru.learnup.operasales.repository.UserRepository;
import ru.learnup.operasales.service.PremiereService;

@SpringBootApplication
public class OperasalesApplication {

    /**
     * Для простоты каждому пользователю в таблице USERS БД H2 соответствует одна роль
     */

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(OperasalesApplication.class, args);

        System.out.println("\nAdd 2 users...");
        PasswordEncoder passwordEncoder = ctx.getBean(PasswordEncoder.class);
        DbUserRepository dbUserRepository = ctx.getBean(DbUserRepository.class);

        dbUserRepository.save(new DbUser("user", passwordEncoder.encode("user123"), "ROLE_USER"));
        dbUserRepository.save(new DbUser("admin", passwordEncoder.encode("admin123"), "ROLE_ADMIN"));

        UserRepository userRepository = ctx.getBean(UserRepository.class);
        User user = userRepository.getUserByUsername("user");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getAuthorities());

        user = userRepository.getUserByUsername("admin");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getAuthorities());

        System.out.println("\nAdd 3 items...");
        PremiereService premiereService = ctx.getBean(PremiereService.class);

        premiereService.addPremiere(new Premiere("Премьера 1", "Описание премьеры 1", AgeCategory.CATEGORY_6PLUS.getName(), 60));
        premiereService.addPremiere(new Premiere("Премьера 2", "Описание премьеры 2", AgeCategory.CATEGORY_12PLUS.getName(), 120));
        premiereService.addPremiere(new Premiere("Премьера 3", "Описание премьеры 3", AgeCategory.CATEGORY_18PLUS.getName(), 180));

    }

}