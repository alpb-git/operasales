package ru.learnup.operasales.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.learnup.operasales.model.DbUser;
import ru.learnup.operasales.model.User;

@Repository
public class UserRepository {

    private final DbUserRepository dbUserRepository;

    @Autowired
    public UserRepository(DbUserRepository dbUserRepository) {
        this.dbUserRepository = dbUserRepository;
    }

    public User getUserByUsername(String username) {
        DbUser dbUser = dbUserRepository.getDbUserByUsername(username);
        if (dbUser != null) {
            return new User(dbUser.getUsername(), dbUser.getPassword(), dbUser.getRoleName());
        }
        return null;
    }

}