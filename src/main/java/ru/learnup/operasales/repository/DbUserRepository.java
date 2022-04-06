package ru.learnup.operasales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.learnup.operasales.model.DbUser;

@Repository
public interface DbUserRepository extends JpaRepository<DbUser, String> {

    @Query("from DbUser as u where u.username = :username")
    DbUser getDbUserByUsername(String username);

}