package ru.learnup.operasales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.learnup.operasales.model.Premiere;
public interface PremiereRepository extends JpaRepository<Premiere, Long> {

    void deleteById(Long aLong);

    Premiere findPremiereByName(String name);

}