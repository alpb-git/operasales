package ru.learnup.operasales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.learnup.operasales.model.Premiere;

public interface PremiereRepository extends JpaRepository<Premiere, Long> {

    @Query("from Premiere as p where p.name = :name")
    Premiere getPremiereByName(String name);

}